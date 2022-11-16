package com.cognixia.jump.project3spring.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;

@Inheritance
@Entity
public abstract class Food implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;

	@Column(insertable = false, updatable = false)
	private String dtype;

	@Column(nullable = false)
	private double cost;

	enum Veggies {
		Lettuce, Onions, Pickles, Tomato, Jalapeños, Mushrooms, Pinapple, Olives, GreenPeppers
	};

	enum Cheese {
		American, Blue, Cheddar, Swiss, Provolone, PepperJack, RedDragon, Mozzarella
	};
	
	enum Sauce {
		Ketchup, BBQ, Ranch, Hot
	}

	private ArrayList<Veggies> veggies;
	private Cheese cheese;
	private Sauce sauce;

	@ManyToOne
	private Orders order;
	

	public Food(Long id, double cost, ArrayList<Veggies> veggies, Cheese cheese, Sauce sauce,
			Orders order) {
		super();
		this.id = id;
		this.cost = cost;
		this.veggies = veggies;
		this.cheese = cheese;
		this.sauce = sauce;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public ArrayList<Veggies> getVeggies() {
		return veggies;
	}

	public void setVeggies(ArrayList<Veggies> veggies) {
		this.veggies = veggies;
	}

	public Cheese getCheese() {
		return cheese;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", dtype=" + dtype + ", cost=" + cost + ", veggies=" + veggies + ", cheese=" + cheese
				+ ", sauce=" + sauce + ", order=" + order + "]";
	}

}
