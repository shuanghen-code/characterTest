package com.example.service.impl;

import com.example.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author wanglongfei
 * @date 2021/12/8 15:06
 * @description 邮件服务实现类
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;   //发送者

    @Override
    public void send(String testerMail, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        //设置发送者
        message.setFrom(from);
        //设置发送日期
        message.setSentDate(new Date());
        //设置邮件主题
        message.setSubject(subject);
        //设置邮件内容
        message.setText(text);
        //设置收件人
        message.setTo(testerMail);
        //发送
        mailSender.send(message);
    }
}
