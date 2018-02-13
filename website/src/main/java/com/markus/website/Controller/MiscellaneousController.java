package com.markus.website.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("MarkusWeb/Miscellaneous")
public class MiscellaneousController extends BaseController {
	
	@GetMapping("/MiscellaneousContainer")
	ModelAndView getMiscContaner() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Miscellaneous/MiscellaneousContainer");
		return modelAndView;
	}
	
	@GetMapping("/ComingSoon")
	ModelAndView getPlaceHolderContaner() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Miscellaneous/ComingSoon");
		return modelAndView;
	}
}
