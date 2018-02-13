package com.markus.website.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cs_skill")
@JsonIgnoreProperties(allowGetters=true)
public class SkillEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@Column(name="skill_name")
	private String skillName;
	
	@ManyToOne
	@JoinColumn(name="skill_type_name", referencedColumnName="skill_type_name")
	private SkillTypeEntity skillTypeEntity;
	
	public SkillTypeEntity getSkillTypeEntity() {
		return this.skillTypeEntity;
	}

	public void setSkillTypeEntity(SkillTypeEntity skillTypeEntity) {
		this.skillTypeEntity = skillTypeEntity;
	}

	public String getSkillName() {
		return this.skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	public String getSkillTypeName() {
		return this.skillTypeEntity.getSkillTypeName();
	}
	
	public void setSkillTypeName(String skillTypeName) {
		this.skillTypeEntity.setSkillTypeName(skillTypeName);
	}
	
}
