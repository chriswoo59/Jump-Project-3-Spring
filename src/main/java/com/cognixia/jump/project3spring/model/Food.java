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

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private double cost;


	public Food(Long id, String type, double cost) {
		super();
		this.id = id;
		this.type = type;
		this.cost = cost;
	}

	public Food() {
		this.id = -1L;
		this.type = "blank";
		this.cost = 5.0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", type=" + type + ", cost=" + cost + "]";
	}

}
