/**
 * 
 */
package com.budthapa.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author budthapa Feb 25, 2017
 * 
 */
@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${mail.enable}")
	private Boolean enable;
/*
	private TemplateEngine templateEngine;

	public EmailService(){}
	
	@Autowired
	public EmailService(TemplateEngine templateEngine){
		this.templateEngine=templateEngine;
	}
	
	public String buildMail(MimeMessage message){
		Context context = new Context();
		context.setVariable("message", message);
		return templateEngine.process("emailTemplate", context);
	}
	*/
	
	@Autowired
	private MailContentBuilder mailContentBuilder;
	
	public void sendVerificationEmail(String emailAddress) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

		messageHelper.setTo(emailAddress);
		messageHelper.setFrom(new InternetAddress("no-reply@budthapa.pro"));
		messageHelper.setSubject("verify for your email");
		messageHelper.setSentDate(new Date());
		
		
		String content = mailContentBuilder.buildMessage(message);
		messageHelper.setText(content);
		
//		messageHelper.setText("Testing the email sending feature");

		if (enable) {
			mailSender.send(message);
		}
	}
}
