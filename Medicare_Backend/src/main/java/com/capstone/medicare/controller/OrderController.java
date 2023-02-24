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
import com.capstone.medicare.model.OrderProd;
import com.capstone.medicare.service.OrderService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/OrderProd")
public class OrderController
{
	@Autowired
	private OrderService service;
	@PostMapping("")
	public ResponseEntity<Object> saveOrderProd(@RequestBody OrderProd OrderProd){
		
		OrderProd resp=service.saveOrderProd(OrderProd);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Error while creating object",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("")
	public List<OrderProd> getAll(){
		return service.getAllOrderProd();
	}
	@GetMapping("{id}")
	public ResponseEntity<Object> getById(@PathVariable int id){
		OrderProd resp=service.getOrderProdById(id);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.OK);
		else
			return new ResponseEntity<>("no user available",HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateOrderProd(@RequestBody OrderProd c,@PathVariable int id)
	{
		OrderProd resp=service.updateOrderProd(c, id);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.OK);
		else
			return new ResponseEntity<>("no user available to update",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteOrderProd(@PathVariable int id){
		if(service.deleteOrderProd(id))
			return new ResponseEntity<>("true",HttpStatus.OK);
		else
			return new ResponseEntity<>("false",HttpStatus.NOT_FOUND);
	}
	
}
