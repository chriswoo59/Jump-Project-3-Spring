package com.cognixia.jump.project3spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.cognixia.jump.project3spring.model.Food.Cheese;
import com.cognixia.jump.project3spring.model.Food.Veggies;

@Component
public class Burger extends Food implements Serializable{

	private static final long serialVersionUID = 1L;

	private enum Extras{Bacon,FriedEgg,Avocado};
	private enum Protein{Single,Double,Turkey,BlackBean};
	private enum Buns{White,Wheat,Lettuce,GlutenFree};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;
	@ManyToOne
	private Orders order;
	
	@Column
	private Extras extras;
	@Column
	private Protein protein;
	@Column
	private Buns buns;
	
	public Burger() {
		super();
		super.setType("Burger");
	}
	
	public Burger(Long id, double cost, ArrayList<Veggies> veggies, Cheese cheese, Extras extras, Protein protein, Buns buns) {
		super(id, "Burger", cost, veggies, cheese);
		this.extras = extras;
		this.protein = protein;
		this.buns = buns;
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

	public Extras getExtras() {
		return extras;
	}

	public void setExtras(Extras extras) {
		this.extras = extras;
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
		return "Burger [id=" + id + ", order=" + order + ", protein=" + protein + ", buns=" + buns + "]";
	}
	
}
