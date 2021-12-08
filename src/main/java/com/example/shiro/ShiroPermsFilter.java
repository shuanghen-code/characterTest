package com.example.shiro;

import cn.hutool.core.util.StrUtil;
import com.example.controller.BaseController;
import com.example.entity.ReturnBean;
import com.example.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 扩展shiro授权拦截器
 */
public class ShiroPermsFilter extends PermissionsAuthorizationFilter {
    /**
     * 授权失败的时候执行的内容
     * @param request
     * @param response
     * @param mappedValue
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (StrUtil.isNotEmpty(httpServletRequest.getHeader(Constants.HEADER_TYPE)) && httpServletRequest.getHeader(Constants.HEADER_TYPE).equalsIgnoreCase(Constants.HEADER_CONTENT)) {
            // 如果是ajax请求
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("utf-8");
            BaseController baseController = new BaseController();
            ReturnBean returnBean = baseController.fail(null);
            ObjectMapper objectMapper = new ObjectMapper();
            // 将对象转换成json字符串
            String asString = objectMapper.writeValueAsString(returnBean);
            httpServletResponse.getWriter().write(asString);
        } else {
            // 如果不是ajax请求，跳转到无权限页面
            httpServletResponse.sendRedirect("/unau.html");
        }
        return false;
    }
}
