package com.simk.controller;

import com.simk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Controller
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        testService.input();
        return "ok";
    }


    @Autowired
    JavaMailSenderImpl javaMailSender;

    @GetMapping("/test1")
    @ResponseBody
    public void test1() {
        //封装简单的邮件内容
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件主题
        message.setSubject("放假通知");
        message.setText("春节放假7天");
        //发件人
        message.setFrom("q1470970746@163.com");
        message.setTo("1470970746@qq.com");
        javaMailSender.send(message);
    }

    @GetMapping("/test2")
    @ResponseBody
    public void test2() throws MessagingException {
         //创建一个发送复杂消息对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //通过消息帮助对象，来设置发送的内容
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        //邮件主题
        messageHelper.setSubject("测试邮件");
        //第2个参数为true表示是html
        messageHelper.setText("<h2 style='color:red'>测试邮件</h2>" +
                "" +
                "<img src=\"https://www.abbreviationfinder.org/images/acronym/cn/tu/p5/tup.pngg\" style=\"display: block;\" width=\"\" border=\"0\">", true);
        //上传文件 (文件名，File或IO对象)
        messageHelper.addAttachment("1.jpeg", new File("E:\\图库\\1.jpeg"));
        messageHelper.addAttachment("2.jpeg", new File("E:\\图库\\1.jpeg"));
        messageHelper.addAttachment("3.jpeg", new File("E:\\图库\\1.jpeg"));

        //发件人
        messageHelper.setFrom("q1470970746@163.com");
        messageHelper.setTo("1470970746@qq.com");
        javaMailSender.send(mimeMessage);
    }
}
