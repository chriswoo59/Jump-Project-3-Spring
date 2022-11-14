package com.cognixia.jump.project3spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognixia.jump.project3spring.model.Food;
import com.cognixia.jump.project3spring.service.FoodService;

@Configuration 
public class FoodController {

	@Autowired
	FoodService service;
	
	
	@GetMapping("/food")
	public List<Food> getAllFood(){
		return service.getAllFood();
	}
	
	
}
