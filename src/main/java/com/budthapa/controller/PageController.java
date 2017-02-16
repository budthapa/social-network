package com.budthapa.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/addstatus", "/addStatus"})
	ModelAndView addStatus(ModelAndView modelAndView, @ModelAttribute("statusUpdate") StatusUpdate statusUpdate){
		modelAndView.setViewName("addStatus");
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate());		
		return modelAndView;
	}
	
	@RequestMapping(value="/addStatus",method=RequestMethod.POST)
	ModelAndView addStatus(ModelAndView modelAndView, @ModelAttribute("statusUpdate") @Valid StatusUpdate statusUpdate, 
			BindingResult result){
		modelAndView.setViewName("addStatus");
		
		if(!result.hasErrors()){
			statusUpdateService.save(statusUpdate);			
			modelAndView.getModel().put("statusUpdate", new StatusUpdate());
		}
		
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate());
		return modelAndView;
	}
	
	@RequestMapping(value="/viewstatus", method=RequestMethod.GET)
	ModelAndView viewStatus(ModelAndView modelAndView, @RequestParam(name="p", defaultValue="1") int pageNumber){
		Page<StatusUpdate> page=statusUpdateService.getPage(pageNumber);
		for(StatusUpdate p:page.getContent()){
			System.out.println("Pge content "+p.getText());
		}
		modelAndView.getModel().put("page", page);
		modelAndView.setViewName("viewstatus");
		return modelAndView;
	}
	
	private StatusUpdate latestStatusUpdate(){
		return statusUpdateService.getLatest();
	}
}
