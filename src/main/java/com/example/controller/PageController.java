package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wang hao
 * @date 2021/11/28 10:38
 */
public class PageController {

    @RequestMapping("toExam")
    public String toExam(){
        return "exam";
    }

}
