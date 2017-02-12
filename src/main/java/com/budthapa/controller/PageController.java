package com.budthapa.controller;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.budthapa.domain.StatusUpdate;

@Controller
public class PageController {
	static final Logger log = LoggerFactory.getLogger(PageController.class);
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	String index(){
		log.info("Serving index page");
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/addstatus")
	ModelAndView addStatus(ModelAndView modelAndView){
		log.info("Serving status page");
		modelAndView.setViewName("addStatus");
		StatusUpdate statusUpdate=new StatusUpdate();
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		return modelAndView;
	}
}
