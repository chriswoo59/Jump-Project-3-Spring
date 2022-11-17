package com.cognixia.jump.project3spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cognixia.jump.project3spring.model.Food;

@Repository
public interface FoodRepository<T extends Food>  extends JpaRepository<T, Long>{

	@Query("SELECT u FROM Food u WHERE u.order.id = ?1")
	public List<Food> findByOrder(long x);
	
	@Query("SELECT u FROM Food u WHERE u.cost >= ?#{[0]}")
	public List<Food> findFoodCostMoreThan(double cost);
	
}