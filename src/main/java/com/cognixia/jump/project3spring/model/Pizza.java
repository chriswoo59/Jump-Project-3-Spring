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

	private enum Meats {
		Pepperoni, Sausage, Bacon, Meatball, Ham, Chicken, Beef, Pork
	};

	private enum Crust {
		HandTossed, Pan, NewYork, DeepDish, StuffedCrust
	};

	private ArrayList<Meats> meat = new ArrayList<>();
	private Crust crust;

	public Pizza() {
		super(-1L, 8.00, new ArrayList<>(), Cheese.Mozzarella, null, null);
		this.meat = new ArrayList<>();
		this.crust = Crust.HandTossed;
	}

	public Pizza(Long id, double cost, ArrayList<Veggies> veggies, Cheese cheese, Sauce sauce, Orders order,
			ArrayList<Meats> meat, Crust crust) {
		super(id, cost, veggies, cheese, sauce, order);
		this.meat = meat;
		this.crust = crust;
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
		return "Pizza [meat=" + meat + ", crust=" + crust + "]";
	}

}
