package com.budthapa.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	static final Logger log = LoggerFactory.getLogger(PageController.class);
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	String index(){
		log.info("Serving index page");
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/addstatus")
	String addStatus(){
		log.info("Serving status page");
		return "addStatus";
	}
}
