package com.yourslife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yourslife.db.NutritionDimensionRepository;
import com.yourslife.domain.NutritionDimension;

@Controller
public class JustFirstController2 {

	
	@Autowired
	NutritionDimensionRepository nutritionDimensionRepository;
	
	@RequestMapping("/just")
	public ModelAndView test(Model model) {
		System.out.println("test is running");
//		model.addAttribute("res1", "works");
		List<NutritionDimension> list = nutritionDimensionRepository.findAll();
		model.addAttribute("res2", list);
		return new ModelAndView("test", "params", model);
	}

}
