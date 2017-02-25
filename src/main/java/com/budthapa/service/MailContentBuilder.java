/**
 * 
 */
package com.budthapa.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author budthapa
 * Feb 25, 2017
 * 
 */
@Service
public class MailContentBuilder {
	
	private TemplateEngine templateEngine;
	
	public MailContentBuilder(){}
	
	@Autowired
	public MailContentBuilder(TemplateEngine templateEngine){
		this.templateEngine=templateEngine;
	}
	
	public String buildMessage(MimeMessage message){
		Context context = new Context();
		context.setVariable("message", message);
		return templateEngine.process("emailTemplate", context);
	}

}
