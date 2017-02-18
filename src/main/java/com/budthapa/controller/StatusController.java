/**
 * 
 */
package com.budthapa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.budthapa.service.StatusUpdateService;

/**
 * @author budthapa
 * Feb 18, 2017
 * 
 */
@Controller
public class StatusController {
	
	@Autowired
	StatusUpdateService statusUpdateService;
	
	@RequestMapping(value="/deletestatus", method=RequestMethod.GET) 
	ModelAndView deleteStatus(ModelAndView modelAndView, @RequestParam Long id){
		System.out.println("clicked delete link");
		if(statusUpdateService.idExists(id)?true:false){
			statusUpdateService.delete(id);			
		}
		modelAndView.setViewName("redirect:/viewstatus");
		return modelAndView;
	}
}
