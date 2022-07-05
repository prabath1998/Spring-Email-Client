package com.test.emailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("prabathoff@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        try {
            mailSender.send(message);
            System.out.println("Mail Send...");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
