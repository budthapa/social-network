package com.budthapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.budthapa.domain.SiteUser;

@Controller
public class AuthController {
	
	
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
	
}
