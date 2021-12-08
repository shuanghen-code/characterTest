package com.example.controller;

import com.example.entity.ReturnBean;
import com.example.entity.Tester;
import com.example.entity.TesterVo;
import com.example.service.MailService;
import com.example.service.TesterService;
import com.example.util.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author：WangLongFei
 * @Date：2021/12/8 21:51
 */
@RestController
@RequestMapping("mail")
public class MailController extends BaseController{

    @Resource
    private MailService mailService;

    @Resource
    private TesterService testerService;

    @RequestMapping("/sendMail")
    public ReturnBean sendMail(String testerMail, HttpSession session){
        Tester tester = (Tester) session.getAttribute("tester");
        List<TesterVo> testerVoList = testerService.selectAllColor(Constants.page, Constants.limit, tester);
        mailService.send(testerMail,"性格测试结果","性格测试结果的内容分析");
        return super.success(testerVoList);
    }
}
