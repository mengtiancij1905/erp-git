package com.itqf.erp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author 飞鸟
 * @date 2019/7/19 - 11:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/applicationContext-mail.xml")
public class SendMailDemo {
    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void test01(){
        //创建邮件
        MimeMessage mime = javaMailSender.createMimeMessage();
        //邮件包装工具
        MimeMessageHelper helper = new MimeMessageHelper(mime);

        try {
            //发件人
            helper.setFrom("studyitluma@sina.com");
            //收件人
            helper.setTo("2814779294@qq.com");
            //主题
            helper.setSubject("测试邮件");
            //内容
            helper.setText("你要是收到这封邮件，你就成功了，嘿嘿~~~~");
            javaMailSender.send(mime);
            System.out.println("邮件发送成功！");

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
