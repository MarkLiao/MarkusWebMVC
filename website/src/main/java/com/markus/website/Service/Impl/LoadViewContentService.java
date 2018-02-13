package com.markus.website.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markus.website.Dao.API.ILoadViewContentDao;
import com.markus.website.Entity.ViewContentEntity;
import com.markus.website.Service.API.ILoadViewContentService;

@Service
public class LoadViewContentService implements ILoadViewContentService {

	@Autowired
	ILoadViewContentDao loadViewContentDao;
	
	@Override
	public Map<String, String> loadViewContentValues(String viewName){
		Map<String, String> contentMap = new HashMap<>();
		contentMap = loadLabels(contentMap, viewName);
		contentMap = loadContent(contentMap, viewName);
		contentMap = loadLinks(contentMap, viewName);
		return contentMap;
	}
	
	private Map<String, String> loadLabels(Map<String, String> contentMap, String viewName) {
		List<ViewContentEntity> labelList = this.loadViewContentDao.getTitlesAndHeaders(viewName);
		return createContentMapping(contentMap, labelList);
	}
	
	private Map<String, String> loadContent(Map<String, String> contentMap, String viewName){
		List<ViewContentEntity> contentList = this.loadViewContentDao.getContent(viewName);
		return createContentMapping(contentMap, contentList);
	}
	
	private Map<String, String> loadLinks(Map<String, String> contentMap, String viewName){
		List<ViewContentEntity> linksList = this.loadViewContentDao.getLinks(viewName);
		return createContentMapping(contentMap, linksList);
	}
	
	private Map<String, String> createContentMapping(Map<String, String> contentMap, List<ViewContentEntity> list){
		for(ViewContentEntity viewContentEntity : list) {
			contentMap.put(viewContentEntity.getAngularScopeName(), viewContentEntity.getContentValue());
		}
		return contentMap;
	}
	
}
