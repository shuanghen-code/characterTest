package com.example.service;

/**
 * @author wanglongfei
 * @date 2021/12/8 15:04
 * @description 发送邮件的服务类
 */
public interface MailService {

    void send(String to, String subject, String text);
}
