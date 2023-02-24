package com.capstone.medicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.medicare.model.Cart;
import com.capstone.medicare.model.Product;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>
{
	//@Query(value = "select P.product_name ,P.product_desc from Products P,Cart C where P.product_id=C.product_id AND C.user_id=:id",nativeQuery = true)
	//@Query(value = "SELECT * FROM customer where custmail:custmail  AND , nativeQuery = true)
	@Query(value = "select P from Product P,Cart C where P.productId=C.product.productId AND C.user.id=:id")
	List<Object> findProdcutById(Long id);
	
	
	@Query(value = "select C from Cart C where C.user.id=:uid")
	 List<Object> findCartByUid(Long uid);
}
