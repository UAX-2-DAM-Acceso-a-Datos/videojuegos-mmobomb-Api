package com.uax.accesodatos.videojuegosmmobombApi.utils;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.uax.accesodatos.videojuegosmmobombApi.dto.MailDTO;

import jakarta.mail.internet.MimeMessage;
import jakarta.mail.*;

@Component
public class VideojuegosUtils {

	@Autowired
	private SpringTemplateEngine springtemplateengine;
	
	@Autowired
	private JavaMailSender emailSender;
	
	public void formarEmail(MailDTO mail, String mailtemplate) throws MessagingException {
		MimeMessage mimeM =  emailSender.createMimeMessage();
		MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeM, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
		
		Context context = new Context();
        context.setVariables(mail.getProps());
        
		mimeHelper.setSubject(mail.getAsunto());
		mimeHelper.setTo(mail.getTo());
		mimeHelper.setFrom(mail.getFrom());
        
        String htmlMapeado = springtemplateengine.process(mailtemplate, context);
        mimeHelper.setText(htmlMapeado, true);
        
		emailSender.send(mimeM);
	}
}
