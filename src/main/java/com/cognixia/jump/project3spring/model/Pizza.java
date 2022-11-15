package com.cognixia.jump.project3spring.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
public class Pizza extends Food {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;
	
	@ManyToOne
	private Orders order;

	private enum Veggies{Onions,Tomato,Jalapeños,Mushrooms,Pinapple,Olives,GreenPeppers};
	private enum Meats{Pepperoni,Sausage,Bacon,Meatball,Ham,Chicken,Beef,Pork};
	private enum Crust{HandTossed,Pan,NewYork,DeepDish,StuffedCrust};
	
	private ArrayList<Veggies> veg = new ArrayList<>();
	private ArrayList<Meats> meat= new ArrayList<>();
	private Crust crust;

	public Pizza() {
		super();
		this.meat = new ArrayList<Meats>();
		this.crust = null;
	}

	public Pizza(Long id, String type, double cost, Orders order, ArrayList<Veggies> veg, ArrayList<Meats> meat,
			Crust crust) {
		super(id, type, cost);
		this.order = order;
		this.veg = veg;
		this.meat = meat;
		this.crust = crust;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public ArrayList<Veggies> getVeg() {
		return veg;
	}

	public void setVeg(ArrayList<Veggies> veg) {
		this.veg = veg;
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
		return "Pizza [order=" + order + ", veg=" + veg + ", meat=" + meat + ", crust=" + crust + "]";
	}
	
	

}
