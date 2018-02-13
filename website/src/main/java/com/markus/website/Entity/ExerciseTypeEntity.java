package com.markus.website.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="exercise_type")
public class ExerciseTypeEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String exerciseName;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="exerciseTypEntity")
	private List<RoutineEntity> routineEntity;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="exerciseTypeEntity")
	private List<PRStatsEntity> prStatsEntity;
	
	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public List<RoutineEntity> getRoutineEntity() {
		return routineEntity;
	}

	public void setRoutineEntity(List<RoutineEntity> routineEntity) {
		this.routineEntity = routineEntity;
	}

	public List<PRStatsEntity> getPrStatsEntity() {
		return prStatsEntity;
	}

	public void setPrStatsEntity(List<PRStatsEntity> prStatsEntity) {
		this.prStatsEntity = prStatsEntity;
	}
	
}
