package com.capstone.medicare.service;

import java.util.List;

import com.capstone.medicare.model.Cart;
import com.capstone.medicare.model.Product;

public interface CartService
{
	public Cart saveCart(Cart c); //create Customer
	public List<Cart> getAllCart(); //getAll Customers
	public Cart updateCart(Cart c,int id); //update customer by Id
	public boolean deleteCart(int id); //delete customer By Id
	public Cart getCartById(int id); //find customer b
	public List<Object> getProductById(long Id);
	public List<Object>getCartByUserId(long Id);

}
