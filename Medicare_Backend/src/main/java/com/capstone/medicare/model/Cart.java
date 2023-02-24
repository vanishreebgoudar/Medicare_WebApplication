package com.capstone.medicare.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Cart
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartId")
	private long cartId;
	
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer user;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	private long cartQty;
	
	

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public long getCartQty() {
		return cartQty;
	}

	public void setCartQty(long cartQty) {
		this.cartQty = cartQty;
	}
	

	
	

}
