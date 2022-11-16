package com.cognixia.jump.project3spring.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
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

	@Autowired
	OrdersService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrder(){
		List<Orders> order = service.getAllOrders();
		
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@PostMapping("/order")
	public ResponseEntity<?> createOrder( @CurrentSecurityContext(expression = "authentication") Authentication authentication) throws ResourceNotFoundException {
		Orders order =new Orders();
		order.setOrder_date(Date.valueOf(LocalDate.now()));
		order.setQty(0);
		order.setId(-1l);
		order.setCompleted(false);
		Orders created = service.addOrders(order);
		created= service.addUserToOrder(authentication.getName(), created.getId());
		
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
