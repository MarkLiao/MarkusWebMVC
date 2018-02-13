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

@Entity
@Table(name="routine")
public class RoutineEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="exercise_type", referencedColumnName="name")
	private ExerciseTypeEntity exerciseTypEntity;
	
	@Column(name="day_of_week")
	private String dayOfWeek;

	public ExerciseTypeEntity getExerciseTypEntity() {
		return exerciseTypEntity;
	}

	public void setExerciseTypEntity(ExerciseTypeEntity exerciseTypEntity) {
		this.exerciseTypEntity = exerciseTypEntity;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
}
