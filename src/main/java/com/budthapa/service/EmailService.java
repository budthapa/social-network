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

	public void sendVerificationEmail(String emailAddress) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

		messageHelper.setTo(emailAddress);
		messageHelper.setFrom(new InternetAddress("no-reply@budthapa.pro"));
		messageHelper.setSubject("verify for your email");
		messageHelper.setSentDate(new Date());

		messageHelper.setText("Testing the email sending feature");

		if (enable) {
			mailSender.send(message);
		}
	}
}
