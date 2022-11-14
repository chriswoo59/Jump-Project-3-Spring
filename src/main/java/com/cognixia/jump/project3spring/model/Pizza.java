package com.cognixia.jump.project3spring.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
public class Pizza extends Food {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;
	@ManyToOne
	private Orders order;

	private enum Meats {
		Pepperoni, Sausage, Bacon, Meatball, Ham, Chicken, Beef, Pork
	};

	private enum Crust {
		HandTossed, Pan, NewYork, DeepDish, StuffedCrust
	};

	private ArrayList<Meats> meat = new ArrayList<>();
	private Crust crust;

	public Pizza(Long id, double cost, ArrayList<Veggies> veggies, Cheese cheese, ArrayList<Meats> meat, Crust crust) {
		super(id, "Pizza", cost, veggies, cheese);
		this.meat = meat;
		this.crust = crust;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public ArrayList<Meats> getMeat() {
		return meat;
	}

	public void setMeat(ArrayList<Meats> meat) {
		this.meat = meat;
	}

	public Crust getCrust() {
		return crust;
	}

	public void setCrust(Crust crust) {
		this.crust = crust;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", order=" + order + ", meat=" + meat + ", crust=" + crust + "]";
	}

}
