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
@Table(name="pr_stats")
public class PRStatsEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="exercise_type", referencedColumnName="name")
	private ExerciseTypeEntity exerciseTypeEntity;
	
	@Column(name="exercise_name")
	private String exerciseName;
	
	@Column(name="time_record")
	private String timeRecord;
	
	@Column(name="distance")
	private Double distance;
	
	@Column(name="weight")
	private Double weight;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="is_favorite")
	private String isFavorite;

	public ExerciseTypeEntity getExerciseType() {
		return exerciseTypeEntity;
	}

	public void setExerciseType(ExerciseTypeEntity exerciseType) {
		this.exerciseTypeEntity = exerciseType;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getTimeRecord() {
		return timeRecord;
	}

	public void setTimeRecord(String timeRecord) {
		this.timeRecord = timeRecord;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(String isFavorite) {
		this.isFavorite = isFavorite;
	}
	
}
