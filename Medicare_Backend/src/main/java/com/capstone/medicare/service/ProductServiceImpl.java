package com.capstone.medicare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.medicare.model.Customer;
import com.capstone.medicare.model.Product;
import com.capstone.medicare.repository.ProductRepository;

@Service
public class ProductServiceImpl  implements ProductService
{

	//injected the Repository dependency
	@Autowired
	ProductRepository repo;

	@Override
	public Product saveProduct(Product c) {
		return repo.save(c);
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public Product updateProduct(Product newData, int id) {
		if (repo.findById((long) id).isPresent()) {
			Product oldData = repo.findById((long) id).get();
			oldData.setProductName(newData.getProductName());
			oldData.setBrand(newData.getBrand());
			oldData.setCategory(newData.getCategory());
			oldData.setProductDesc(newData.getProductDesc());
			oldData.setProductPrice(newData.getProductPrice());
			oldData.setQty(newData.getQty());
			oldData.setProductImg(newData.getProductImg());
			return repo.save(oldData);
		} 
		else
			return null;
	}

	@Override
	public boolean deleteProduct(long id) {
		if (repo.findById( id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Product getProdById(int id) {
		if (repo.findById((long) id).isPresent()) {
			return repo.findById((long) id).get();
		}
		return null;
	}
	
	public List<Product> getProductByName(String word){
		return repo.findByName(word);
	}
}

