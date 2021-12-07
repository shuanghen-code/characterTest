package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author wanglongfei
 * @date 2021/12/7 15:43
 * @description 切面类
 */
@EnableAspectJAutoProxy
@Component
@Aspect
public class MyAspect {

    //定义一个切入点
    @Pointcut("execution(public void com.example.service.impl.UserServiceImpl.*(..))")
    public void method(){}

//    @Before("method()")
//    public void myEnhance(){
//        /**
//          *@Description：增强处理
//          *@Return：void
//          *@Author：wangLongFei
//          *@Date：2021/12/7
//          */
//        System.out.println("饭前洗手");
//    }
//
//    @AfterReturning("method()")
//    public void myEnhance1(){
//        System.out.println("饭后漱口");
//    }

    @Around("method()")
    public void myEnhance3(ProceedingJoinPoint joinPoint){

        try {
            System.out.println("饭前洗手");
            //执行业务方法
            joinPoint.proceed();
            System.out.println("敲代码");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }

    }
}
