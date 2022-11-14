package com.cognixia.jump.project3spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognixia.jump.project3spring.model.Food;
import com.cognixia.jump.project3spring.repository.BurgerRepository;
import com.cognixia.jump.project3spring.repository.PizzaRepository;

@Service
public class FoodService {
	
	BurgerRepository brepo;
	PizzaRepository prepo;

	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		ArrayList<Food> foodList= new ArrayList<>();
		foodList.addAll(brepo.findAll());
		foodList.addAll(prepo.findAll());
		return foodList;
	}

	
	
	
}
