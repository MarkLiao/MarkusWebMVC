package com.markus.website.Dao.API;

import java.util.List;
import com.markus.website.Entity.ViewContentEntity;

public interface ILoadViewContentDao {
	
	List<ViewContentEntity> getTitlesAndHeaders(String viewName);
	List<ViewContentEntity> getContent(String viewName);
	List<ViewContentEntity> getLinks(String viewName);
}
