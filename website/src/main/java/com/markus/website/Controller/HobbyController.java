package com.markus.website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.markus.website.Beans.PRStatBean;
import com.markus.website.Beans.RoutineBean;
import com.markus.website.Service.API.ILoadFitnessService;

@RestController
@RequestMapping("MarkusWeb/Hobbies")
public class HobbyController extends BaseController{
	
	@Autowired
	ILoadFitnessService loadFitnessService;
	
	@GetMapping("/HobbiesContainer")
	ModelAndView getHobbiesContainer(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Hobbies/HobbiesContainer");
		return modelAndView;
	}
	
	@GetMapping("/HobbiesContentContainer")
	ModelAndView getHobbiesContent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/Hobbies/HobbiesContentContainer");
		return modelAndView;
	}
	
	@GetMapping("/FitnessContainer")
	ModelAndView getFitnessContent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/Hobbies/FitnessContainer");
		return modelAndView;
	}
	
	
	@GetMapping("/MusicAndGameContainer")
	ModelAndView getFoodAndMusicContainer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/Hobbies/MusicAndGameContainer");
		return modelAndView;
	}
	
	@GetMapping("/MusicContainer")
	ModelAndView getMusicContent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/Hobbies/MusicContainer");
		return modelAndView;
	}
	
	@GetMapping("/GameContainer")
	ModelAndView getGameContent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/Hobbies/GameContainer");
		return modelAndView;
	}
	
	@GetMapping("/routineList")
	List<RoutineBean> getRoutineList(){
		return this.loadFitnessService.getRoutineList();
	}
	
	@GetMapping("/prStatList")
	List<PRStatBean> getPRStatList(){
		return this.loadFitnessService.getPRStatList();
	}
	
	
}
