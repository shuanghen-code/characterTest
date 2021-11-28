package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wang hao
 * @date 2021/11/28 10:38
 */
@Controller
public class PageController {

    /**
     * @return testLogin
     * @Author hxh
     * @description 页面跳转__去答题页面
     * @Version 1.0
     */
    @RequestMapping("toExam")
    public String toExam(){
        return "exam";
    }

    /**
     * @return testLogin
     * @Author hxh
     * @description 页面跳转__去用户登录页面
     * @Data 2021/11/27 13:01
     * @Version 1.0
     */
    @RequestMapping("toTesterLogin")
    public String toPage() {
        return "testerLogin";
    }


    @RequestMapping("toquestionManager")
    public String toTest() {
        return "questionManager";
    }

}
