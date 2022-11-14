package com.cognixia.jump.project3spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class burger extends food implements Serializable{

	private static final long serialVersionUID = 1L;

	private enum Veggies{Lettuce,Onions,Tomato,Pickles,Jalapeños};
	private enum Cheese{American,Blue,Cheddar,Swiss,PepperJack,RedDragon};
	private enum Extras{Bacon,FriedEgg,Avocado};
	private enum Protein{Single,Double,Turkey,BlackBean};
	private enum Buns{White,Wheat,Lettuce,GlutenFree};
	
	private List<Veggies> topping;
	private List<Extras> extras;
	private Cheese cheese; 
	private Protein protein;
	private Buns buns;
	
	public burger() {
		super();
	}
	
	public burger(List<Veggies> topping, List<Extras> extras, Cheese cheese, Protein protein, Buns buns) {
		super();
		this.topping = topping;
		this.extras = extras;
		this.cheese = cheese;
		this.protein = protein;
		this.buns = buns;
	}
	
	@Override
	public String toString() {
		return "burger [topping=" + topping + ", extras=" + extras + ", cheese=" + cheese + ", protein=" + protein
				+ ", buns=" + buns + "]";
	}

	public List<Veggies> getTopping() {
		return topping;
	}

	public void setTopping(List<Veggies> topping) {
		this.topping = topping;
	}

	public List<Extras> getExtras() {
		return extras;
	}

	public void setExtras(List<Extras> extras) {
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
	
	
}
