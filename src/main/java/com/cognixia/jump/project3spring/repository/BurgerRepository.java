package com.cognixia.jump.project3spring.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognixia.jump.project3spring.model.Burger;

@Repository
public interface BurgerRepository  extends FoodRepository<Burger>{

	public List<Burger> findByOrder(String order);
}
