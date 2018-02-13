package com.markus.website.Service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markus.website.Beans.SkillBean;
import com.markus.website.Dao.API.ISkillDao;
import com.markus.website.Entity.SkillEntity;
import com.markus.website.Entity.SkillTypeEntity;
import com.markus.website.Service.API.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private ISkillDao skillDao;
	
	@Override
	public List<SkillBean> getSkillList() {
		List<SkillTypeEntity> skillTypeList = this.skillDao.getSkillList();
		return makeSkillListBean(skillTypeList);
	}

	public List<SkillBean> makeSkillListBean(List<SkillTypeEntity> skillTypeList) {
		List<SkillBean> skillBeanList = new ArrayList<>();
		for (SkillTypeEntity skillType : skillTypeList) {
			SkillBean skillBean = new SkillBean();
			List<SkillEntity> skillList = skillType.getSkillEntity();
			String skillListString = "";
			for(SkillEntity skill : skillList) {
				if(skillListString.equals("")){
					skillListString +=  skill.getSkillName();
				}else {
					skillListString += ", " + skill.getSkillName();
				}
			}
			skillBean.setSkillName(skillType.getSkillTypeName());
			skillBean.setSkillValue(skillListString);
			skillBeanList.add(skillBean);
		}
		return skillBeanList;
	}
}
