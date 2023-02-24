package com.capstone.medicare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.medicare.model.Customer;
import com.capstone.medicare.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	//injected the Repository dependency
	@Autowired
	CustomerRepository repo;

	@Override
	public Customer saveCustomer(Customer c) {
		return repo.save(c);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer newData, long id) {
		if (repo.findById(id).isPresent()) {
			Customer oldData = repo.findById(id).get();
			oldData.setName(newData.getName());
			oldData.setMail(newData.getMail());
			oldData.setAddress(newData.getAddress());
			oldData.setPassword(newData.getPassword());
			oldData.setPhNo(newData.getPhNo());
			return repo.save(oldData);
		} 
		else
			return null;
	}
  
	@Override
	public boolean deleteCustomer(long id) {
		if (repo.findById(id).isPresent()) 
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustById(long id) {
		if (repo.findById(id).isPresent())
		{
			return repo.findById(id).get();
			
		}
		return null;
	}
	@Override
	public Optional<Customer> getUserByName(String mail,String pwd) {
		Optional<Customer> user = repo.findByName(mail,pwd);
		return user;
	}


}
