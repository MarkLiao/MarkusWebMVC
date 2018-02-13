package com.markus.website.Dao.Impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.markus.website.Dao.API.ISkillDao;
import com.markus.website.Entity.SkillEntity;
import com.markus.website.Entity.SkillTypeEntity;
import com.markus.website.Entity.ViewContentEntity;

@Repository
public class SkillDaoImpl implements ISkillDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final static String SKILLLISTQUERY = "from SkillTypeEntity order by id asc";
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SkillTypeEntity> getSkillList() {
		List<SkillTypeEntity> skillList = (List<SkillTypeEntity>) entityManager.createQuery(SKILLLISTQUERY).getResultList();
		return skillList;
	}

}
