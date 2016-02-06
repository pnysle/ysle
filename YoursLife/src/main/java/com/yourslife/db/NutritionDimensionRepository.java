package com.yourslife.db;

import java.util.List;

import com.yourslife.domain.NutritionDimension;

public interface NutritionDimensionRepository {
	
	NutritionDimension findOne(long id);

	List<NutritionDimension> findAll();
}
