package com.cognixia.jump.project3spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date order_date;
	
	@Column(nullable = false)
	private boolean completed;
	
	@Column(nullable = false)
	private int qty;
	
	public Order() {
		this.id = -1L;
		this.order_date = new Date();
		this.completed = false;
		this.qty = 1;
	}

	public Order(Long id, Date order_date, boolean completed, int qty) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.completed = completed;
		this.qty = qty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order_date=" + order_date + ", completed=" + completed + ", qty=" + qty + "]";
	}
	
	
}
