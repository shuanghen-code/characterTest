package com.example.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro安全框架配置类
 * @author wang hao
 * @date 2021/12/3 18:08
 */
@Configuration
public class ShiroConfig {

    /**
     * @create by: Teacher陈（86521760@qq.com）
     * @description: 密码比较器
     * @create time: 2021/12/3 15:09
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMacther(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1000);
        return hashedCredentialsMatcher;
    }

    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm= new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMacther());
        return myRealm;
    }

    /**
     * securityManager
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager= new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm());
        return defaultWebSecurityManager;
    }

    /**
     * shiroFilterFactorybean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        /**
         * 认证过滤器的分类
         * anon:无需认证
         * authc:必须认证才能到达
         * user:使用rememberme的时候才用
         * perms：访问的资源需要某个权限才能到达
         * roles:访问的资源需要某个角色才能到达
         */
        Map<String, String> map = new LinkedHashMap<>();

        Map<String, Filter> filterMap= new LinkedHashMap<>();
        filterMap.put("perms",new ShiroPermsFilter());

        //放行login
        map.put("/user/managerLogin", "anon");
        map.put("/test/*", "anon");
        map.put("/tester/**","anon");
        map.put("/question/**","anon");
        map.put("/result/**","anon");

        map.put("/css/**", "anon");
        map.put("/image/**", "anon");
        map.put("/js/**", "anon");
        map.put("/layui/**", "anon");
        map.put("/video/**", "anon");

        //添加页面需要有添加的权限才能到达

        //添加问题页面需要有添加的权限才能到达
        map.put("/question/insert","perms[character:question:add]");

        // 去菜单管理页面需要相应的权限才能到达
        map.put("/manager/toMenu","perms[system:menu:view]");

        //过滤所有的请求
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        shiroFilterFactoryBean.setFilters(filterMap);

        //修改登录页面
        shiroFilterFactoryBean.setLoginUrl("/toMlogin");
        //指定未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/toUnau");
        return shiroFilterFactoryBean;
    }

    /**
     * 设置shiro的方言
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
