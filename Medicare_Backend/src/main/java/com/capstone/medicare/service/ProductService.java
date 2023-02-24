package com.capstone.medicare.service;

import java.util.List;
import java.util.Optional;


import com.capstone.medicare.model.Product;

public interface ProductService 
{ 
	public Product saveProduct(Product c); //create Product
    public List<Product> getAllProducts(); //getAll Products
    public Product updateProduct(Product c,int id); //update Product by Id
    public boolean deleteProduct(long id); //delete Product By Id
    public Product getProdById(int id); //find Product b
    public List<Product> getProductByName(String word);
}
