package com.markus.website.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.markus.website.Beans.RoutineBean;
import com.markus.website.Dao.API.IRoutineDao;
import com.markus.website.Entity.RoutineEntity;

@Repository
public class RoutineDaoImpl implements IRoutineDao {

	@PersistenceContext
	EntityManager entityManager;
	
	private static String ROUTINE_QUERY = "from RoutineEntity where dayOfWeek =:day";
	private static String weekArray[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	
	@Override
	public List<RoutineBean> getRoutineList(){
		List<RoutineBean> routineBeanList = new ArrayList<>();
		for(String dayOfWeek : weekArray) {
			List<RoutineEntity> routineList = getRoutineByDay(dayOfWeek);
			RoutineBean routineBean = getRoutineBean(routineList, dayOfWeek);
			routineBeanList.add(routineBean);
		}
		return routineBeanList;
	}
	
	@SuppressWarnings("unchecked")
	private List<RoutineEntity> getRoutineByDay(String day){
		List<RoutineEntity> routineList = (List<RoutineEntity>) entityManager.createQuery(ROUTINE_QUERY).setParameter("day", day).getResultList();
		return routineList;
	}
	
	
	private RoutineBean getRoutineBean(List<RoutineEntity> routineList, String dayOfWeek) {
		RoutineBean routineBean = new RoutineBean();
		String value = "";
		for (RoutineEntity routineEntity : routineList) {
			if(value.equals("")) {
				value = routineEntity.getExerciseTypEntity().getExerciseName();
			}else {
				value = value + " & " + routineEntity.getExerciseTypEntity().getExerciseName();
			}
		}
		routineBean.setDayOfWeek(dayOfWeek);
		routineBean.setValue(value);
		return routineBean;
	}
}
