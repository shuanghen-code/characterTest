package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author wang hao
 * @date 2021/11/28 10:38
 */
@Controller
public class PageController {



    /**
     * @return testerLogin
     * @description 页面跳转__去用户登录页面
     * @Data 2021/11/27 13:01
     * @Version 1.0
     */
    @RequestMapping("toTesterLogin")
    public String toPage() {
        return "testerLogin";
    }

    // 去往答题页面
    @RequestMapping("toExam")
    public String toExam(){
        return "exam";
    }

    // 去往测试完成页面
    @RequestMapping("tofinish")
    public String toFinish(HttpSession session) {
        session.removeAttribute("tester");
        return "finish";
    }

    /**
     * @return login
     * @description 页面跳转__去管理员登录页面
     * @Data 2021/11/27 13:01
     * @Version 1.0
     */
    @RequestMapping("toMlogin")
    public String toMlogin(){
        return "login";
    }

    // 去往管理后台首页
    @RequestMapping("toManagerHome")
    public String toManagerHome(){
        return "managerHome";
    }

    // 去往问题管理页面
    @RequestMapping("toquestionManager")
    public String toTest() {
        return "questionManager";
    }

    // 去往测试结果管理页面
    @RequestMapping("toTester")
    public String toTester(){
        return "testerManager";
    }

    // 去往角色管理页面
    @RequestMapping("toRoleManager")
    public String toRoleManager(){
        return "roleManager";
    }


}
