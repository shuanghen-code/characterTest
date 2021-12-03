package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.UserDao;
import com.example.entity.Menu;
import com.example.entity.ReturnBean;
import com.example.entity.User;
import com.example.service.MenuService;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息表(User)表控制层
 *
 * @author makejava
 * @since 2021-12-02 18:36:55
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 管理员登录验证
     *
     * @return
     */
    @PostMapping("managerLogin")
    public ReturnBean managerLogin(@RequestBody User user) {
        // 获取shiro主体，subject
        Subject subject = SecurityUtils.getSubject();
        // 构建用户登陆的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        // 登录操作
        try {
            subject.login(token);
        } catch (UnknownAccountException u) {
            return super.fail(user, "用户名不存在");
        } catch (IncorrectCredentialsException ie) {
            return super.fail(user, "密码不正确");
        }

        // 获取Myrealm里SimpleAuthenticationInfo存入的user对象
        Object principal = subject.getPrincipal();
        System.out.println(principal);
        return success(principal);
    }

}