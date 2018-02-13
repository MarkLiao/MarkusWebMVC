package com.markus.website.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.markus.website.Dao.API.ILoadViewDao;
import com.markus.website.Service.API.ILoadViewService;

@Service
public class LoadViewServiceImpl implements ILoadViewService {

	private static final String HOME_VIEW_NAME = "Home";
	private static final String PROJECT_VIEW_NAME = "Project";
	private static final String HOBBIES_VIEW_NAME = "Hobbies";
	
	@Autowired
	private ILoadViewDao loadViewDao;
	
	@Override
	public ModelAndView getHomeContainer() {
		return getView("Home");
	}
	
	public ModelAndView getView(String viewName) {
		String path = this.loadViewDao.getViewPath(viewName);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(path);
		return modelAndView;
	}

}
