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
	
	@GetMapping
	public ResponseEntity<?> getAllFood() {
		List<Food> foods = service.getAllFood();
		
		return ResponseEntity.status(HttpStatus.OK).body(foods);
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
		Food deleted = service.deleteFood(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
}
