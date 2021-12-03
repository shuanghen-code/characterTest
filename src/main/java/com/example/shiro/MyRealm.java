package com.example.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author wang hao
 * @date 2021/12/3 18:06
 */
public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;


    /**
     * @create by: Teacher陈（86521760@qq.com）
     * @description: 授权功能
     * @create time: 2021/12/3 15:05
     * @param principals
     * @return org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


    /**
     * @description: 认证功能
     * @create time: 2021/12/3 15:06
     * @param token
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证代码开始执行");
        // 获取令牌对象
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        // 第一步，校验用户是否存在
        String loginName = usernamePasswordToken.getUsername();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", loginName);
        User user = userService.getOne(queryWrapper);
        if (user==null) {
            return null;
        }

        // 第二部，校验密码是否正确
        String password = user.getPassword();
        String salt = user.getSalt();
        ByteSource byteSource = ByteSource.Util.bytes(salt);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, byteSource, getName());
        return simpleAuthenticationInfo;
    }
}
