package com.cognixia.jump.project3spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognixia.jump.project3spring.model.Burger;

public interface BurgerRepository  extends JpaRepository<Burger, Long>{

}
