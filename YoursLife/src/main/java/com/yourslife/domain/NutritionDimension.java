package com.yourslife.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nutrition_dimension")
public class NutritionDimension {

	public NutritionDimension() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dimension_id")
	private int dimensionId;

	@Column(name = "name")
	private String name;

	public int getDimensionId() {
		return dimensionId;
	}

	public void setDimensionId(int dimensionId) {
		this.dimensionId = dimensionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NutritionDimension [dimensionId=" + dimensionId + ", name=" + name + "]";
	}
}
