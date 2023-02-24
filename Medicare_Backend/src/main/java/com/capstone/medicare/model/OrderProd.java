package com.capstone.medicare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderProd
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderId")
	private long orderId;
	
	private long totalPrice;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Customer cust;

    public long getOrderId() {
		return orderId;
	}



	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}



	public Customer getUser() {
		return cust;
	}



	public void setUser(Customer user) {
		this.cust = user;
	}



	public long getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
}
