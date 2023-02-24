package com.capstone.medicare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.capstone.medicare.model.Product;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Long>
{ 
	@Query(value = "select P from Product P where productName like %:word%")
	//@Query(value = "SELECT * FROM customer where custmail:custmail  AND , nativeQuery = true)
	List<Product> findByName(String word);
}