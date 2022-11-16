package com.cognixia.jump.project3spring.model;

import java.io.Serializable;
import java.util.ArrayList;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Burger extends Food implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;

	private enum Veggies {
		Lettuce, Onions, Tomato, Pickles, Jalapeños
	};

	private enum Cheese {
		American, Blue, Cheddar, Swiss, PepperJack, RedDragon
	};

	private enum Extras {
		Bacon, FriedEgg, Avocado
	};

	private enum Protein {
		Single, Double, Turkey, BlackBean
	};

	private enum Buns {
		White, Wheat, Lettuce, GlutenFree
	};

	@ManyToOne
	private Orders order;

	private ArrayList<Veggies> veggies;
	private ArrayList<Extras> extras;
	private Cheese cheese;
	private Protein protein;
	private Buns buns;

	public Burger(Long id, String type, double cost, Orders order, ArrayList<Veggies> veggies, ArrayList<Extras> extras,
			Cheese cheese, Protein protein, Buns buns) {
		super(id, type, cost);
		this.order = order;
		this.veggies = veggies;
		this.extras = extras;
		this.cheese = cheese;
		this.protein = protein;
		this.buns = buns;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public ArrayList<Veggies> getVeggies() {
		return veggies;
	}

	public void setVeggies(ArrayList<Veggies> veggies) {
		this.veggies = veggies;
	}

	public ArrayList<Extras> getExtras() {
		return extras;
	}

	public void setExtras(ArrayList<Extras> extras) {
		this.extras = extras;
	}

	public Cheese getCheese() {
		return cheese;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	public Protein getProtein() {
		return protein;
	}

	public void setProtein(Protein protein) {
		this.protein = protein;
	}

	public Buns getBuns() {
		return buns;
	}

	public void setBuns(Buns buns) {
		this.buns = buns;
	}

	@Override
	public String toString() {
		return "Burger [order=" + order + ", veggies=" + veggies + ", extras=" + extras + ", cheese=" + cheese
				+ ", protein=" + protein + ", buns=" + buns + "]";
	}


}
