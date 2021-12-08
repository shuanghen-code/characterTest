package com.example.aop;

import com.example.entity.Log;
import com.example.entity.User;
import com.example.service.LogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

/**
 * @author wanglongfei
 * @date 2021/12/7 16:04
 * @description 日志类
 */
@EnableAspectJAutoProxy
@Component
@Aspect
public class LogAspect {

    @Autowired
    private LogService logService;
    /**
     * 切入点表达式，切入到所有controller中的所有方法
     */
    @Pointcut("execution(* com.example.controller.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object myEnhance(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        System.out.println(signature + "日志开始打印啦");

        //保存日志信息到数据库中
        Log log = new Log();
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        User user = new User();
        if (principal!=null){
            user= (User) principal;
        }
        log.setLoginName(user.getLoginName());
        log.setUserName(user.getUserName());
        //获取请求的IP地址
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String ip = request.getRemoteAddr();
        log.setIp(ip);
        //获取类名
//        String className = joinPoint.getTarget().getClass().getName();
        log.setClassName(joinPoint.getSignature().getDeclaringTypeName());

        //获取方法名
        String[] split = signature.toString().split("\\.");
        String method = split[split.length-1];
        log.setMethodName(method);
        //获取参数
        String paramString = Arrays.toString(args);
        log.setParams(paramString);
        //设置时间
        log.setCreateTime(new Date());

        logService.save(log);
        try {
            Object proceed = joinPoint.proceed(args);
            return proceed;
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return null;
    }
}
