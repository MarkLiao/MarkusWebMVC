package com.markus.website.Service.API;

import java.util.List;

import com.markus.website.Beans.PRStatBean;
import com.markus.website.Beans.RoutineBean;

public interface ILoadFitnessService {
	List<RoutineBean> getRoutineList();
	List<PRStatBean> getPRStatList();
}
