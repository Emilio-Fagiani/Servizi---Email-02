package com.example.Servizi.Email2.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendTo(String email,String title, String text) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setSubject(title);
        helper.setTo(email);

        boolean html = true;
        String textHtml= "<h1>" +title+"</h1><h2></h2>" +
                "<img src=https://www.adnkronos.com/resources/0275-15370b76ac03-0791eb3b054e-1000/format/big/milan_scudetto_festa_fg.jpg >" +
                "<h3>"+text+"</h3>";
        helper.setText(textHtml, html);

        javaMailSender.send(message);
    }
}
