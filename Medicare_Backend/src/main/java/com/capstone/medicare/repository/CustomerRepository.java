package com.capstone.medicare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.medicare.model.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	@Query(value = "select C from Customer C where C.mail=:custmail AND C.password=:custPwd")
	//@Query(value = "SELECT * FROM customer where custmail:custmail  AND , nativeQuery = true)
	Optional<Customer> findByName(String custmail,String custPwd);


}