package com.markus.website.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.markus.website.Service.API.ILoadViewContentService;

@RestController
@RequestMapping("/MarkusWeb")
public class BaseController {
	
	@Autowired
	private ILoadViewContentService loadViewContentService;
	
	@GetMapping("/home")
	ModelAndView getMain() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WebPageMain");
		return modelAndView;
	}
	
	@GetMapping("/WebNavContainer")
	ModelAndView getWebNavContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WebsiteNavContainer");
		return modelAndView;
	}
	
	@GetMapping("/loadTitles/{page}")
	Map<String, String> getTitles(@PathVariable("page") String viewName){
		return this.loadViewContentService.loadViewContentValues(viewName);
	}
	
	@GetMapping("/loadNavContainer")
	Map<String, String> getNavContainer(){
		return null;
	}
}
