package com.capstone.medicare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.medicare.model.Customer;
import com.capstone.medicare.model.Product;
import com.capstone.medicare.service.ProductService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/product")
public class ProductController 
{   
	@Autowired
	private ProductService service;
	@PostMapping("")
	public ResponseEntity<Object> saveProduct(@RequestBody Product cust){
		
		Product resp=service.saveProduct(cust);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Error while creating object",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("")
	public List<Product> getAll(){
		return service.getAllProducts();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getById(@PathVariable int id){
		Product resp=service.getProdById(id);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.OK);
		else
			return new ResponseEntity<>("no product available",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getUser/{word}")
	public List<Product> getUser(@PathVariable String word)
	{
		List<Product> products = service.getProductByName(word);
		return products;
		
	}
	
	
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product c,@PathVariable int id)
	{
		Product resp=service.updateProduct(c, id);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.OK);
		else
			return new ResponseEntity<>("no user available to update",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable long id){
		if(service.deleteProduct(id))
			return new ResponseEntity<>("true",HttpStatus.OK);
		else
			return new ResponseEntity<>("false",HttpStatus.NOT_FOUND);
	}
	
	

}
