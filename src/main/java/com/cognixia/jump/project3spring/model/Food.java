package com.cognixia.jump.project3spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Food implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;
	
	
	private double cost;
	
	private boolean done;

	public Food(Long id, double cost, boolean done) {
		super();
		this.id = id;
		this.cost = cost;
		this.done = done;
	}

	public Food() {
		super();
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", cost=" + cost + ", done=" + done + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}
