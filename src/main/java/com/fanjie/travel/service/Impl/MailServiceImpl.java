package com.fanjie.travel.service.Impl;

import com.fanjie.travel.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 简单邮件发送
     *
     * @param to      收件人
     * @param content 内容
     * @param title   主题
     */
    public void simpleSendMail(String to, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        sender.send(message);
    }
}
