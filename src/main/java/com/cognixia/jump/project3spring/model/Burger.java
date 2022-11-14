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

@Entity
public class Burger extends Food implements Serializable{

	private static final long serialVersionUID = 1L;

	private enum Protein{Single,Double,Turkey,BlackBean};
	private enum Buns{White,Wheat,Lettuce,GlutenFree};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;
	@ManyToOne
	private Orders order;
	
	@Column
	private Protein protein;
	@Column
	private Buns buns;
	
	public Burger() {
		super();
		super.setType("Burger");
	}
	
	public Burger(Protein protein, Buns buns) {
		super();
		super.setType("Burger");
		this.protein = protein;
		this.buns = buns;
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
