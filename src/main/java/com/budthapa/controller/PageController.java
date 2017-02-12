package com.budthapa.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.budthapa.domain.StatusUpdate;
import com.budthapa.service.StatusUpdateService;

@Controller
public class PageController {
	static final Logger log = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private StatusUpdateService statusUpdateService;
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	String index(){
		log.info("Serving index page");
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/addstatus", "/addStatus"})
	ModelAndView addStatus(ModelAndView modelAndView){
		log.info("Serving status page");
		modelAndView.setViewName("addStatus");
		StatusUpdate statusUpdate=new StatusUpdate();
		//StatusUpdate latestStatusUpdate=statusUpdateService.getLatest();
		
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/addStatus",method=RequestMethod.POST)
	ModelAndView addStatus(ModelAndView modelAndView, StatusUpdate statusUpdate){
		log.info("Saving status");
		modelAndView.setViewName("addStatus");
		statusUpdateService.save(statusUpdate);
		//StatusUpdate latestStatusUpdate=statusUpdateService.getLatest();
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate());
		return modelAndView;
	}
	
	private StatusUpdate latestStatusUpdate(){
		return statusUpdateService.getLatest();
	}
}
