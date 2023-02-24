package com.capstone.medicare.controller;

import java.util.List;

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

import com.capstone.medicare.model.Cart;
import com.capstone.medicare.model.Product;
import com.capstone.medicare.service.CartService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/cart")
public class CartController 
{  
	@Autowired
	private CartService service;
	@PostMapping("")
	public ResponseEntity<Object> saveCart(@RequestBody Cart cart){
		
		Cart resp=service.saveCart(cart);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Error while creating object",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("")
	public List<Cart> getAll(){
		return service.getAllCart();
	}
	@GetMapping("{id}")
	public ResponseEntity<Object> getById(@PathVariable int id){
		Cart resp=service.getCartById(id);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.OK);
		else
			return new ResponseEntity<>("no user available",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getProd/{id}")
	public List<Object> getUser(@PathVariable Long id)
	{
		List<Object> products = service.getProductById(id);
		return products;
		
	}
	@GetMapping("/getCart/{uid}")
	public List<Object> getCart(@PathVariable Long uid)
	{
		List<Object> cart = service.getCartByUserId(uid);
		return cart;
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateCart(@RequestBody Cart c,@PathVariable int id)
	{
		Cart resp=service.updateCart(c, id);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.OK);
		else
			return new ResponseEntity<>("no user available to update",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteCart(@PathVariable int id){
		if(service.deleteCart(id))
			return new ResponseEntity<>("true",HttpStatus.OK);
		else
			return new ResponseEntity<>("false",HttpStatus.NOT_FOUND);
	}
	

}
