package com.cognixia.jump.project3spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.project3spring.exception.ResourceNotFoundException;
import com.cognixia.jump.project3spring.model.Food;
import com.cognixia.jump.project3spring.model.Orders;
import com.cognixia.jump.project3spring.model.User;
import com.cognixia.jump.project3spring.repository.FoodRepository;
import com.cognixia.jump.project3spring.repository.OrdersRepository;
import com.cognixia.jump.project3spring.repository.UserRepository;

@Service
public class OrdersService {
	@Autowired
	OrdersRepository repo;
	
	@Autowired
	FoodRepository<Food> frepo;
	
	@Autowired
	UserRepository urepo;
	
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
	
	public Orders changeStatus(Long id) throws ResourceNotFoundException{
		Orders found=findOrderById(id);
		found.setCompleted(!found.isCompleted());
		repo.save(found);
		return found;
	}
	public boolean checkStatus(Long id) throws ResourceNotFoundException{
		Orders found=findOrderById(id);
		return found.isCompleted();
	}
	
	public Food addOrderToFood(Long orderId, Long foodId) throws ResourceNotFoundException {
		
		Optional<Food> food = frepo.findById(foodId);
		
		if(food.isPresent()) {
			food.get().setOrder(findOrderById(orderId));
			frepo.save(food.get());
			Orders found =findOrderById(orderId);
			found.setQty(findOrderById(orderId).getQty()+1);
			repo.save(found);
			return food.get();
		}
		throw new ResourceNotFoundException("Food",foodId);
	}
	public Orders addUserToOrder(String username, Long orderId) throws ResourceNotFoundException {
		
		Optional<User> user = urepo.findByUsername(username);
		
		if(user.isPresent()) {
			Orders order = findOrderById(orderId);
			order.setUser(user.get());
			repo.save(order);
			return order;
		}
		throw new ResourceNotFoundException("User",username);
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
