package com.cognixia.jump.project3spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.project3spring.exception.ResourceNotFoundException;
import com.cognixia.jump.project3spring.model.Food;
import com.cognixia.jump.project3spring.model.Orders;
import com.cognixia.jump.project3spring.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	OrdersService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrder(){
		List<Orders> order = service.getAllOrders();
		
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@PostMapping("/order")
	public ResponseEntity<?> createOrder(@RequestBody Orders order) {
		Orders created = service.addOrders(order);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	@GetMapping("/status/{id}")
	public ResponseEntity<?> checkStatusOrdersById(@PathVariable Long id) throws ResourceNotFoundException {
		boolean status = service.checkStatus(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	@PostMapping("/status/{id}")
	public ResponseEntity<?> changeStatusOrdersById(@PathVariable Long id) throws ResourceNotFoundException {
		Orders status = service.changeStatus(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	@PostMapping("/user/{userId}/{orderId}")
	public ResponseEntity<?> addUser(@PathVariable Long userId,@PathVariable Long orderId) throws ResourceNotFoundException {
		Orders order = service.addUserToOrder(userId,orderId);		
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	@PostMapping("/food/{orderId}/{foodId}")
	public ResponseEntity<?> addFood(@PathVariable Long orderId,@PathVariable Long foodId) throws ResourceNotFoundException {
		Food food = service.addOrderToFood(orderId,foodId);		
		return ResponseEntity.status(HttpStatus.OK).body(food);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteOrdersById(@PathVariable Long id) throws ResourceNotFoundException {
		Orders deleted = service.deleteOrders(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
}
