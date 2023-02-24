package com.capstone.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.medicare.model.OrderProd;
@Repository
public interface OrderRepository extends JpaRepository<OrderProd, Long>
{

}
