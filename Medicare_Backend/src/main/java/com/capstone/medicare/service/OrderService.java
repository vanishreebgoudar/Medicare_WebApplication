package com.capstone.medicare.service;

import java.util.List;

import com.capstone.medicare.model.OrderProd;

public interface OrderService
{
	public OrderProd saveOrderProd(OrderProd c); //create Customer
	public List<OrderProd> getAllOrderProd(); //getAll Customers
	public OrderProd updateOrderProd(OrderProd c,int id); //update customer by Id
	public boolean deleteOrderProd(int id); //delete customer By Id
	public OrderProd getOrderProdById(int id); //find customer b
}
