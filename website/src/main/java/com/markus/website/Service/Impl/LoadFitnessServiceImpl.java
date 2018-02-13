package com.markus.website.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markus.website.Beans.PRStatBean;
import com.markus.website.Beans.RoutineBean;
import com.markus.website.Dao.API.IPRStatsDao;
import com.markus.website.Dao.API.IRoutineDao;
import com.markus.website.Entity.PRStatsEntity;
import com.markus.website.Service.API.ILoadFitnessService;

@Service
public class LoadFitnessServiceImpl implements ILoadFitnessService {

	@Autowired
	private IRoutineDao routineDao;
	
	@Autowired
	private IPRStatsDao prStatDao;
	
	@Override
	public List<RoutineBean> getRoutineList() {
		return this.routineDao.getRoutineList();
	}

	@Override
	public List<PRStatBean> getPRStatList() {
		List<PRStatsEntity> prStatsList = this.prStatDao.getPrStats();
		return createPRStatBeanList(prStatsList);
	}
	
	private List<PRStatBean> createPRStatBeanList(List<PRStatsEntity> prStatsList){
		List<PRStatBean> prStatBeanList = new ArrayList<>();
		for(PRStatsEntity prStat : prStatsList) {
			PRStatBean statBean = new PRStatBean();
			statBean.setName(prStat.getExerciseName());
			if(prStat.getTimeRecord() != null && prStat.getExerciseType().getExerciseName().equals("Cardio")) {
				statBean.setValue(prStat.getDistance() + prStat.getUnit() + " in " + prStat.getTimeRecord());
			}else if (prStat.getDistance() != null) {
				statBean.setValue(prStat.getDistance() + prStat.getUnit());
			}else if (prStat.getWeight() != null) {
				statBean.setValue(prStat.getWeight() + prStat.getUnit());
			}else if (prStat.getExerciseType().getExerciseName().equals("Abs")) {
				statBean.setValue(prStat.getTimeRecord());
			}
			prStatBeanList.add(statBean);
		}
		return prStatBeanList;
	}

}
