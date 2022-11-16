package com.cognixia.jump.project3spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.project3spring.model.Food;

@Repository
public interface FoodRepository<T extends Food>  extends JpaRepository<T, Long>{

	public List<Food> findByOrder(String id);
	
	
}