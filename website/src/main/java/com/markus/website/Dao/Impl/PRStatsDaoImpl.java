package com.markus.website.Dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.markus.website.Dao.API.IPRStatsDao;
import com.markus.website.Entity.PRStatsEntity;

@Repository
public class PRStatsDaoImpl implements IPRStatsDao {

	@PersistenceContext
	EntityManager entityManager;
	
	private static String PRSTAT_QUERY = "from PRStatsEntity";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PRStatsEntity> getPrStats() {
		List<PRStatsEntity> prStatsList = (List<PRStatsEntity>) entityManager.createQuery(PRSTAT_QUERY).getResultList();
		return prStatsList;
	}

}
