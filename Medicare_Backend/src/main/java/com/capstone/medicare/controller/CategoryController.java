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

import com.capstone.medicare.model.Category;
import com.capstone.medicare.service.CategoryService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/category")
public class CategoryController
{
	@Autowired
	private CategoryService service;
	@PostMapping("")
	public ResponseEntity<Object> saveCategory(@RequestBody Category cust){
		
		Category resp=service.saveCategory(cust);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Error while creating object",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("")
	public List<Category> getAll(){
		return service.getAllCategory();
	}
	@GetMapping("{id}")
	public ResponseEntity<Object> getById(@PathVariable int id){
		Category resp=service.getCategoryById(id);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.OK);
		else
			return new ResponseEntity<>("no user available",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateCategory(@RequestBody Category c,@PathVariable int id)
	{
		Category resp=service.updateCategory(c, id);
		if(resp!=null)
			return new ResponseEntity<>(resp,HttpStatus.OK);
		else
			return new ResponseEntity<>("no user available to update",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteCategory(@PathVariable int id){
		if(service.deleteCategory(id))
			return new ResponseEntity<>("user Deleted successfully",HttpStatus.OK);
		else
			return new ResponseEntity<>("no user available to delete",HttpStatus.NOT_FOUND);
	}
	
	
	

}
