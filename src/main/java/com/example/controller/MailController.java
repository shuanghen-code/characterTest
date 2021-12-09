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
    public ReturnBean sendMail(TesterVo testerVo){
        System.out.println(testerVo);
        int[] arr = {testerVo.getBlueCount(),testerVo.getRedCount(),testerVo.getGreenCount(),testerVo.getYellowCount()};
        int max = arr[0];
        String text = "性格测试结果的内容分析";
        for (int i = 0;i<arr.length;i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        for (int i = 0;i<arr.length;i++){
            if (max == arr[i]){
                switch (i){
                    case 0:
                        text = "您的性格为蓝色";
                        break;
                    case 1:
                        text = "您的性格为红色";
                        break;
                    case 2:
                        text = "您的性格为绿色";
                        break;
                    case 3:
                        text = "您的性格为黄色";
                        break;
                }
            }
        }
        String testerMail = testerVo.getPhonenum() + "@139.com";
//        List<TesterVo> testerVoList = testerService.selectAllColor(Constants.page, Constants.limit, tester);
//        for (TesterVo testerVo : testerVoList){
//            System.out.println(testerVo);
//        }

        mailService.send(testerMail,"性格测试结果",text);
        return super.success(testerVo);
    }
}
