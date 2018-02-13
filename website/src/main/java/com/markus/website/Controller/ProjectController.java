package com.markus.website.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/MarkusWeb/Project")
public class ProjectController {
	@GetMapping("/ProjectContainer")
	ModelAndView getProjectPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Project/ProjectContainer");
		return modelAndView;
	}
	
	@GetMapping("/ProjectTabContainer")
	ModelAndView getProjectTabContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Project/ProjectTabContainer");
		return modelAndView;
	}
	
	@GetMapping("/AngularWebsite")
	ModelAndView getAngularWebsiteView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Project/AngularWebsite");
		return modelAndView;
	}
	
	@GetMapping("/WorkoutProfile")
	ModelAndView getWorkoutProfileView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Project/WorkoutProfile");
		return modelAndView;
	}
	
	@GetMapping("/FitnessQuest")
	ModelAndView getFitnessQuestView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Project/FitnessQuest");
		return modelAndView;
	}
	
	@GetMapping("/FlipNMatch")
	ModelAndView getFlipNMatchView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Project/FlipNMatch");
		return modelAndView;
	}
	
	
	@GetMapping("/MathQWhiz")
	ModelAndView getMathQwhizView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Project/MathQwhiz");
		return modelAndView;
	}
	

}
