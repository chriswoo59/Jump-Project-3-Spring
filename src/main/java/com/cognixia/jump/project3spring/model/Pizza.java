package com.cognixia.jump.project3spring.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	public Pizza(Long id, double cost, boolean done, ArrayList<Veggies> veg, ArrayList<Meats> meat, Crust crust) {
		super(id, cost, done);
		this.veg = veg;
		this.meat = meat;
		this.crust = crust;
	}

	@Override
	public String toString() {
		return "Pizza [veg=" + veg + ", meat=" + meat + ", crust=" + crust + "]";
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
	
}
