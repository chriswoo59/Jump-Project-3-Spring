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
import com.cognixia.jump.project3spring.model.Orders;
import com.cognixia.jump.project3spring.service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrdersController {

	OrdersService service;
	
	@GetMapping("/orders")
	public ResponseEntity<?> getAllFood(){
		List<Orders> order = service.getAllOrders();
		
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<?> createOrder(@RequestBody Orders order) {
		Orders created = service.addOrders(order);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	@GetMapping("/orders/{id}/status")
	public ResponseEntity<?> checkStatusOrdersById(@PathVariable Long id) throws ResourceNotFoundException {
		boolean status = service.checkStatus(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	@PostMapping("/orders/{id}/status")
	public ResponseEntity<?> changeStatusOrdersById(@PathVariable Long id) throws ResourceNotFoundException {
		Orders status = service.changeStatus(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<?> deleteOrdersById(@PathVariable Long id) throws ResourceNotFoundException {
		Orders deleted = service.deleteOrders(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
}
