package com.capstone.medicare.service;

import java.util.List;

import com.capstone.medicare.model.Category;

public interface CategoryService
{
	
	public Category saveCategory(Category c); //create Customer
	public List<Category> getAllCategory(); //getAll Customers
	public Category updateCategory(Category c,int id); //update customer by Id
	public boolean deleteCategory(int id); //delete customer By Id
	public Category getCategoryById(int id); //find customer b

}