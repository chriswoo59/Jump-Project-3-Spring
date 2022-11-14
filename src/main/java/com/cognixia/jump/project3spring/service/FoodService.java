package com.cognixia.jump.project3spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.project3spring.exception.ResourceNotFoundException;
import com.cognixia.jump.project3spring.model.Burger;
import com.cognixia.jump.project3spring.model.Food;
import com.cognixia.jump.project3spring.model.Pizza;
import com.cognixia.jump.project3spring.repository.FoodRepository;

@Service
public class FoodService {

	@Autowired
	FoodRepository repo;
	
	public List<Food> getAllFood() {
		return repo.findAll();
	}

	public Burger createBurger(Burger burger) {
		return repo.save(burger);
	}
	
	public Pizza createPizza(Pizza pizza) {
		return repo.save(pizza);
	}

	public Food deleteFood(Long id) throws ResourceNotFoundException {
		Optional<Food> found = repo.findById(id);
		if (found.isPresent()) {
			repo.delete(found.get());
			return found.get();
		}
		throw new ResourceNotFoundException("Food", id);
	}
}
