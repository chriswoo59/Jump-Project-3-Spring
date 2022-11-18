package com.cognixia.jump.project3spring.service;


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
		return repo.findAll();
	}
	
	public List<Burger> getAllBurgers() {
		return brepo.findAll();
	}
	
	public List<Pizza> getAllPizzas() {
		return prepo.findAll();
	}

	public Burger createBurger(Burger burger) {
		return brepo.save(burger);
	}
	
	public Pizza createPizza(Pizza pizza) {
		return prepo.save(pizza);
	}
	
	public List<Food> findCostAbove(double cost){
		
		return repo.findFoodCostMoreThan(cost);
	}
	
	public Burger updateBurger(Burger updateBurger) {
		return brepo.save(updateBurger);
	}
	
	public Pizza updatePizza(Pizza updatePizza) {
		return prepo.save(updatePizza);
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
<<<<<<< HEAD
	
	public Burger  updateBurger( Burger burger, int burgerid) 
	{
		list.stream().map(Burger-> {
			if(Burger.getId()==burgerId)
			{
				Burger.setVeggies(burger.getVeggies());
				Burger.setCheese(burger.getCheese());
				Burger.setExtras(burger.getExtras());
				Burger.setBuns(burger.getBuns());
				Burger.setProtein(burger.getProtein());
			}
			
		});
		return burger;
	}

	public Pizza updatePizza( Pizza pizza, int pizzaid) 
	{
		list.stream().map(Pizza-> {
			if(Pizza.getId()==pizzaId)
			{
				Pizza.setVeggies(pizza.getVeggies());
				Pizza.setMeats(pizza.getMeats());
				Pizza.setCrust(pizza.getCrust());
			}
		});
	
		
		return pizza;
	}


	
=======

	public List<Food> findByOrders(long id) {
		return repo.findByOrder(id);
	}
>>>>>>> main
}
