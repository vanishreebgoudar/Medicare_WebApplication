package com.capstone.medicare.service;

import java.util.List;
import java.util.Optional;

import com.capstone.medicare.model.Customer;

public interface CustomerService 
{
	public Customer saveCustomer(Customer c); //create Customer
	public List<Customer> getAllCustomers(); //getAll Customers
	public Customer updateCustomer(Customer c,long id); //update customer by Id
	public boolean deleteCustomer(long id); //delete customer By Id
	public Customer getCustById(long id); //find customer b
	public Optional<Customer> getUserByName(String name,String pwd);
}