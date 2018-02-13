package com.markus.website.Dao.API;

import java.util.List;

import com.markus.website.Entity.SkillEntity;
import com.markus.website.Entity.SkillTypeEntity;

public interface ISkillDao {
	List<SkillTypeEntity> getSkillList();
}
