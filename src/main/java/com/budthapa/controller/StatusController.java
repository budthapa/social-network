/**
 * 
 */
package com.budthapa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.budthapa.domain.StatusUpdate;
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
	
	@RequestMapping(value="/editstatus/{id}", method=RequestMethod.GET)
	ModelAndView editStatus(ModelAndView modelAndView, @PathVariable Long id){
		StatusUpdate statusUpdate=statusUpdateService.getStatus(id);
		if(statusUpdate!=null){
			modelAndView.getModel().put("statusUpdate", statusUpdate);
			modelAndView.setViewName("editstatus");
		}else{
			modelAndView.setViewName("redirect:/viewstatus");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/editstatus", method=RequestMethod.POST)
	ModelAndView editStatus(ModelAndView modelAndView, @Valid StatusUpdate statusUpdate, BindingResult result){
		if(!result.hasErrors()){
			statusUpdateService.save(statusUpdate);
		}
		modelAndView.setViewName("editstatus");
		return modelAndView;
	}
}
