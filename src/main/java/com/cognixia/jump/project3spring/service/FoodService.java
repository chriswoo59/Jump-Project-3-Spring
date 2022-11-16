package com.cognixia.jump.project3spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.project3spring.exception.ResourceNotFoundException;
import com.cognixia.jump.project3spring.model.Burger;
import com.cognixia.jump.project3spring.model.Food;
import com.cognixia.jump.project3spring.model.Pizza;
import com.cognixia.jump.project3spring.repository.BurgerRepository;
import com.cognixia.jump.project3spring.repository.FoodRepository;
import com.cognixia.jump.project3spring.repository.PizzaRepository;

@Service
public class FoodService {
	
	@Autowired
	FoodRepository<Food> repo;

	@Autowired
	BurgerRepository brepo;
	
	@Autowired
	PizzaRepository prepo;
	
	public List<Food> getAllFood() {
		List<Food> foods = new ArrayList<Food>();
		foods.addAll(brepo.findAll());
		foods.addAll(prepo.findAll());
				
		//return foods;
		return repo.findAll();
	}
	
	public List<Burger> getAllBurgers() {
		return brepo.findAll();
	}
	
	public List<Pizza> getAllPizzas() {
		return prepo.findAll();
	}
	public List<Food> getAllFood(){
		List<Food> foodlist=new ArrayList<>();
		foodlist.addAll(brepo.findAll());
		foodlist.addAll(prepo.findAll());
		
		return foodlist;
		
	}

	public Burger createBurger(Burger burger) {
		return brepo.save(burger);
	}
	
	public Pizza createPizza(Pizza pizza) {
		return prepo.save(pizza);
	}

	public Burger deleteBurger(Long id) throws ResourceNotFoundException {
		Optional<Burger> found = brepo.findById(id);
		if (found.isPresent()) {
			brepo.delete(found.get());
			return found.get();
		}
		throw new ResourceNotFoundException("Burger", id);
	}
	
	public Pizza deletePizza(Long id) throws ResourceNotFoundException {
		Optional<Pizza> found = prepo.findById(id);
		if (found.isPresent()) {
			prepo.delete(found.get());
			return found.get();
		}
		throw new ResourceNotFoundException("Pizza", id);
	}

	public Food deleteFood(Long id) throws ResourceNotFoundException {
		Optional<Food> found = repo.findById(id);
		if (found.isPresent()) {
			repo.delete(found.get());
			return found.get();
		}
		throw new ResourceNotFoundException("Pizza", id);
	}
}
