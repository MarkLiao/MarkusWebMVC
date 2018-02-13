package com.markus.website.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.markus.website.Beans.SkillBean;
import com.markus.website.Service.API.IHomeService;
import com.markus.website.Service.API.ILoadViewService;

@RestController
@RequestMapping("/MarkusWeb/Home")
public class HomeController extends BaseController{
	
	@Autowired
	private IHomeService homeService;
	
	@Autowired
	private ILoadViewService loadViewService;
		
	@GetMapping("/HomeContainer")
	ModelAndView getHomeContainer() {
		return this.loadViewService.getHomeContainer();
	}
	
	@GetMapping("/IntroContainer")
	ModelAndView getIntoContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Home/IntroContainer");
		return modelAndView;
	}
	
	@GetMapping("/AboutMeContainer")
	ModelAndView getAboutMeContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Home/AboutMeContainer");
		return modelAndView;
	}
	
	@GetMapping("/SkillsContainer")
	ModelAndView getSkillsContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Home/SkillsContainer");
		return modelAndView;
	}
	
	@GetMapping("/getSkillList")
	List<SkillBean> getSkillList(){
		return this.homeService.getSkillList();
	}
	
	
}