package com.yourslife.db.hibernate5;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yourslife.db.NutritionDimensionRepository;
import com.yourslife.domain.NutritionDimension;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryTestConfig.class)
public class NutritionDimensionRepositoryTest {

	 @Autowired
	 NutritionDimensionRepository nutritionDimensionRepository;

	 @Test
	 @Transactional
	 public void findAll() {
		 System.out.println("Start");
		 List<NutritionDimension> all = nutritionDimensionRepository.findAll();
		 all.forEach(dimension->System.out.println(dimension.getDimensionId() + "=>" + dimension.getName()));
		 Assert.assertTrue(false);
		 System.out.println("End");
	 }

}
