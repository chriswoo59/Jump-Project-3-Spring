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

	private enum Extras {
		Bacon, FriedEgg, Avocado
	};

	private enum Patty {
		Single, Double, Turkey, BlackBean
	};

	private enum Buns {
		White, Wheat, Lettuce, GlutenFree
	};

	private ArrayList<Extras> extras;
	private Patty patty;
	private Buns buns;

	public Burger() {
		super(-1L, 5.0, new ArrayList<>(), Cheese.American, null, null);
		this.extras = new ArrayList<>();
		this.patty = Patty.Single;
		this.buns = Buns.Wheat;
	}

	public Burger(Long id, double cost, ArrayList<Veggies> veggies, Cheese cheese, Sauce sauce, Orders order,
			ArrayList<Extras> extras, Patty patty, Buns buns) {
		super(id, cost, veggies, cheese, sauce, order);
		this.extras = extras;
		this.patty = patty;
		this.buns = buns;
	}

	public ArrayList<Extras> getExtras() {
		return extras;
	}

	public void setExtras(ArrayList<Extras> extras) {
		this.extras = extras;
	}

	public Patty getPatty() {
		return patty;
	}

	public void setPatty(Patty patty) {
		this.patty = patty;
	}

	public Buns getBuns() {
		return buns;
	}

	public void setBuns(Buns buns) {
		this.buns = buns;
	}

	@Override
	public String toString() {
		return "Burger [extras=" + extras + ", patty=" + patty + ", buns=" + buns + "]";
	}


}
