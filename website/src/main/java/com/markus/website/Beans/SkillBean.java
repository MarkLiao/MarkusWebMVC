package com.markus.website.Beans;

public class SkillBean {
	private String skillName;
	private String skillValue;
	
	public SkillBean() {
		
	}
	
	public SkillBean(String skillName, String skillValue) {
		this.skillName = skillName;
		this.skillValue = skillValue;
	}
	
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillValue() {
		return skillValue;
	}
	public void setSkillValue(String skillValue) {
		this.skillValue = skillValue;
	}
	
	
}
