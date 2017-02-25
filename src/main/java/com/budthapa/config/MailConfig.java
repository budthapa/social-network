/**
 * 
 */
package com.budthapa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author budthapa
 * Feb 25, 2017
 * 
 */
@Configuration
public class MailConfig {
	
	@Value("${mail.smtp.host}")
	private String host;
	@Value("${mail.smtp.port}")
	private int port;
	@Value("${mail.smtp.user}")
	private String username;
	@Value("${mail.smtp.pass}")
	private String password;

	@Bean
	public JavaMailSender mailSender(){
		JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		return mailSender;
	}
}
