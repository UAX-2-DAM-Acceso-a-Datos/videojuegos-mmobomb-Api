package com.uax.accesodatos.videojuegosmmobombApi.utils;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.uax.accesodatos.videojuegosmmobombApi.dto.Mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public class UserUtils {

    @Autowired
    SpringTemplateEngine springTemplateEngine;

    @Autowired
    private JavaMailSender emailSender;

    public void formarEmail(Mail mail, String templateHtml) {
        try {
            MimeMessage mimeM = emailSender.createMimeMessage();


            Context context = new Context();
            context.setVariables(mail.getProps());

            MimeMessageHelper mimeMHelper = new MimeMessageHelper(mimeM, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            mimeMHelper.setSubject(mail.getAsunto());
            mimeMHelper.setTo(mail.getTo());
            mimeMHelper.setFrom(mail.getForm());


            String htmlMapeado = springTemplateEngine.process(templateHtml, context);
            mimeMHelper.setText(htmlMapeado, true);

            emailSender.send(mimeM);


        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}