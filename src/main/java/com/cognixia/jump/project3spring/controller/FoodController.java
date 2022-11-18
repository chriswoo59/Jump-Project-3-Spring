package com.cognixia.jump.project3spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.project3spring.exception.ResourceNotFoundException;
import com.cognixia.jump.project3spring.model.Burger;
import com.cognixia.jump.project3spring.model.Food;
import com.cognixia.jump.project3spring.model.Pizza;
import com.cognixia.jump.project3spring.service.FoodService;

@RestController
@RequestMapping("/api/food")
public class FoodController {

	@Autowired
	FoodService service;

	@GetMapping("/all")
	// Returns a combined list of both burgers and pizzas, in that order
	public ResponseEntity<?> getAllFood() {
		List<Food> foods = service.getAllFood();
		
		return ResponseEntity.status(HttpStatus.OK).body(foods);

	}
	@GetMapping("/cost/{cost}")
	public ResponseEntity<?> getFoodByCostMore(@PathVariable double cost) 
	{
		List<Food> foods = service.findCostAbove(cost);
		
		return ResponseEntity.status(HttpStatus.OK).body(foods);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<?> getFoodByOrder(@PathVariable long id) 
	{
		List<Food> foods = service.findByOrders(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(foods);
	}
	
	
	@GetMapping("/burgers")
	public ResponseEntity<?> getAllBurgers() {
		List<Burger> burgers = service.getAllBurgers();
		
		return ResponseEntity.status(HttpStatus.OK).body(burgers);
	}
	
	@GetMapping("/pizzas")
	public ResponseEntity<?> getAllPizzas() {
		List<Pizza> pizzas = service.getAllPizzas();
		
		return ResponseEntity.status(HttpStatus.OK).body(pizzas);
	}
	
	@PostMapping("/burger")
	public ResponseEntity<?> createBurger(@RequestBody Burger burger) {
		Burger created = service.createBurger(burger);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PostMapping("/pizza")
	public ResponseEntity<?> createPizza(@RequestBody Pizza pizza) {
		Pizza created = service.createPizza(pizza);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
//	@PatchMapping("/burger")
//	public ResponseEntity<?> updateTopping(@RequestParam String topping) {
//		
//	}
	
//	@DeleteMapping("/burger/{id}")
//	public ResponseEntity<?> deleteBurgerById(@PathVariable Long id) throws ResourceNotFoundException {
//		Burger deleted = service.deleteBurger(id);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(deleted);
//	}
//	
//	@DeleteMapping("/pizza/{id}")
//	public ResponseEntity<?> deletePizzaById(@PathVariable Long id) throws ResourceNotFoundException {
//		Pizza deleted = service.deletePizza(id);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(deleted);
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFoodById(@PathVariable Long id) throws ResourceNotFoundException {
		Food deleted = service.deleteFood(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
	
//	@PutMapping("/burger/{food_id}")
//	public ResponseEntity<?> updateBurgerById(@PathVariable Long id) throws ResourceNotFoundException {
//		Burger updated = service.updateBurger(id);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(updated);
//	}
//	
//	@PutMapping("/pizza/{food_id}")
//	public ResponseEntity<?> updatePizzaById(@PathVariable Long id) throws ResourceNotFoundException {
//		Pizza updated = service.updatePizza(id);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(updated);
//	}
	
	
}
