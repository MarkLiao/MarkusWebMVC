package com.markus.website.Dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.markus.website.Dao.API.ILoadViewDao;
import com.markus.website.Entity.ViewsEntity;

@Repository
public class LoadViewDaoImpl implements ILoadViewDao {
	@PersistenceContext
	EntityManager entityManager;

	private final static String viewHQL = "from ViewsEntity where name =:viewName";
	
	@Override
	public String getViewPath(String viewName) {
		ViewsEntity viewsEntity = (ViewsEntity) entityManager.createQuery(viewHQL).setParameter("viewName", viewName).getSingleResult();
		return viewsEntity.getViewPath();
	}
	
	
}
