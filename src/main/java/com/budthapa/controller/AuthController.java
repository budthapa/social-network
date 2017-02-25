package com.budthapa.controller;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.budthapa.domain.SiteUser;
import com.budthapa.service.EmailService;
import com.budthapa.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping("/login")
	String admin(){
		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET )
	ModelAndView register(ModelAndView modelAndView){

		SiteUser user=new SiteUser();
		modelAndView.getModel().put("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	ModelAndView register(ModelAndView modelAndView, @Valid @ModelAttribute("user") SiteUser user, BindingResult result) throws MessagingException{
		modelAndView.setViewName("register");
		if(!result.hasErrors()){
			userService.register(user);
			
			System.out.println("sending email : "+user.getEmail());
			emailService.sendVerificationEmail(user.getEmail());
			
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}
	
}
