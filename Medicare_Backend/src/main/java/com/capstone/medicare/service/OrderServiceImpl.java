package com.capstone.medicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.medicare.model.OrderProd;
import com.capstone.medicare.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	OrderRepository repo;

	@Override
	public OrderProd saveOrderProd(OrderProd c) {
		return repo.save(c);
	}

	@Override
	public List<OrderProd> getAllOrderProd() {
		return repo.findAll();
	}

	@Override
	public OrderProd updateOrderProd(OrderProd newData, int id) {
		if (repo.findById((long) id).isPresent()) {
			OrderProd oldData = repo.findById((long) id).get();
			oldData.setTotalPrice(newData.getTotalPrice());
			oldData.setUser(newData.getUser());
			;
			return repo.save(oldData);
		} 
		else
			return null;
	}

	@Override
	public boolean deleteOrderProd(int id) {
		if (repo.findById((long) id).isPresent()) {
			repo.deleteById((long) id);
			return true;
		}
		return false;
	}

	@Override
	public OrderProd getOrderProdById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
