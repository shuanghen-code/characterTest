package com.example.controller;

import cn.hutool.core.util.ArrayUtil;
import com.example.entity.ReturnBean;
import com.example.entity.TesterVo;
import com.example.service.MailService;
import com.example.util.MailText;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：WangLongFei
 * @Date：2021/12/8 21:51
 */
@RestController
@RequestMapping("mail")
public class MailController extends BaseController {

    @Resource
    private MailService mailService;

    @RequestMapping("/sendMail")
    public ReturnBean sendMail(TesterVo testerVo) {
        int blue = testerVo.getBlueCount();
        int red = testerVo.getRedCount();
        int green = testerVo.getGreenCount();
        int yellow = testerVo.getYellowCount();

        int[] arr = {blue, red, green, yellow};
        int max = ArrayUtil.max(arr);

        String text = "性格测试结果的内容分析";
        if (max == blue) {
            text = MailText.blueText;
        } else if (max == red) {
            text = MailText.redText;
        } else if (max == green) {
            text = MailText.greenText;
        } else if (max == yellow) {
            text = MailText.yellowText;
        }
        String testerMail = testerVo.getPhonenum() + "@139.com";
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        text = text + "\n测试时间：\n" +sdf.format(testerVo.getTestTime());
        mailService.send(testerMail, "【"+ testerVo.getTesterName()+ "】的"+"性格测试结果", text);
        return super.success(testerVo);
    }
}
