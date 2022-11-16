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
	public Orders findOrderById(Long id) throws ResourceNotFoundException {
		Optional<Orders> found = repo.findById(id);
		if (found.isPresent()) {
			return found.get();
		}
		throw new ResourceNotFoundException("Order", id);
	}
	
	public Orders changesStatus(Long id) throws ResourceNotFoundException{
		Orders found=findOrderById(id);
		found.setCompleted(!found.isCompleted());
		repo.save(found);
		return found;
	}
	public boolean checkStatus(Long id) throws ResourceNotFoundException{
		Orders found=findOrderById(id);
		return found.isCompleted();
	}
	
	
	public Orders addOrders(Orders order) {
		
		return repo.save(order);
		
	}
	
	public Orders deleteOrders(Long id) throws ResourceNotFoundException {
		Orders found=findOrderById(id);
		repo.delete(found);
		return found;
	}
	
}
