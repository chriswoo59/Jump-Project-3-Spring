package com.cognixia.jump.project3spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.project3spring.exception.ResourceNotFoundException;
import com.cognixia.jump.project3spring.model.Orders;
import com.cognixia.jump.project3spring.repository.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	OrdersRepository repo;
	
	public List<Orders> getAllOrders(){
		
		return repo.findAll();
	}
	
	
	public Orders addOrders(Orders order) {
		
		return repo.save(order);
		
	}
	
	public Orders deleteOrders(Long id) throws ResourceNotFoundException {
		Optional<Orders> found = repo.findById(id);
		if (found.isPresent()) {
			repo.delete(found.get());
			return found.get();
		}
		throw new ResourceNotFoundException("Order", id);
	}
	
}
