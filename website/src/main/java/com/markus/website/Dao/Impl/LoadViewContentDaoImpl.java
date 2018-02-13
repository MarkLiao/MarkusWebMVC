package com.markus.website.Dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.markus.website.Dao.API.ILoadViewContentDao;
import com.markus.website.Entity.ViewContentEntity;

@Repository
public class LoadViewContentDaoImpl implements ILoadViewContentDao {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static String LABELS_HQL = "from ViewContentEntity as VCE where VCE.elementTypeEntity.elementTypeName =:elementType and VCE.viewsEntity.viewName =:viewName";
	private final static String CONTENT_HQL = "from ViewContentEntity as VCE where VCE.elementTypeEntity.elementTypeName =:elementType and VCE.viewsEntity.viewName =:viewName";
	private final static String LINKS_HQL = "from ViewContentEntity as VCE where VCE.elementTypeEntity.elementTypeName =:elementType and VCE.viewsEntity.viewName =:viewName";
	private final static String ELEMENT_TYPE_LABEL = "label";
	private final static String ELEMENT_TYPE_TEXT = "text";
	private final static String ELEMENT_TYPE_PATH = "path";
	private final static String VARIABLE_ELEMENT_TYPE = "elementType";
	private final static String VARIABLE_VIEW_NAME= "viewName";
	@SuppressWarnings("unchecked")
	@Override
	public List<ViewContentEntity> getTitlesAndHeaders(String viewName) {
		List<ViewContentEntity> titlesAndHeaders = (List<ViewContentEntity>) entityManager.createQuery(LABELS_HQL).setParameter(VARIABLE_ELEMENT_TYPE, ELEMENT_TYPE_LABEL).setParameter(VARIABLE_VIEW_NAME, viewName).getResultList();
		return titlesAndHeaders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ViewContentEntity> getContent(String viewName){
		List<ViewContentEntity> viewContent = (List<ViewContentEntity>) entityManager.createQuery(CONTENT_HQL).setParameter(VARIABLE_ELEMENT_TYPE, ELEMENT_TYPE_TEXT).setParameter(VARIABLE_VIEW_NAME, viewName).getResultList();
		return viewContent;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ViewContentEntity> getLinks(String viewName){
		List<ViewContentEntity> viewContent = (List<ViewContentEntity>) entityManager.createQuery(LINKS_HQL).setParameter(VARIABLE_ELEMENT_TYPE, ELEMENT_TYPE_PATH).setParameter(VARIABLE_VIEW_NAME, viewName).getResultList();
		return viewContent;
	}
}
