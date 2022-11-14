package com.cognixia.jump.project3spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.project3spring.model.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long>{

}
