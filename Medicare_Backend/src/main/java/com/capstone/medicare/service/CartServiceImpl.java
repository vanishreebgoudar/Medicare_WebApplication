package com.capstone.medicare.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.medicare.model.Cart;
import com.capstone.medicare.model.Product;
import com.capstone.medicare.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	CartRepository repo;

	@Override
	public Cart saveCart(Cart c) {
		return repo.save(c);
	}

	@Override
	public List<Cart> getAllCart() {
		return repo.findAll();
	}

	@Override
	public Cart updateCart(Cart newData, int id) {
		if (repo.findById((long) id).isPresent()) {
			Cart oldData = repo.findById((long) id).get();
			oldData.setProduct(newData.getProduct());
			oldData.setUser(newData.getUser());
			oldData.setCartQty(newData.getCartQty());
			return repo.save(oldData);
		} 
		else
			return null;
	}

	@Override
	public boolean deleteCart(int id) {
		if (repo.findById((long) id).isPresent()) {
			repo.deleteById((long) id);
			return true;
		}
		return false;
	}

	@Override
	public Cart getCartById(int id) {
		if (repo.findById((long) id).isPresent()) {
			return repo.findById((long) id).get();
		}
		return null;
	}
	
	@Override
	public List<Object> getProductById(long Id)
	{
		return repo.findProdcutById(Id);
	}
	
	@Override
	public List<Object>getCartByUserId(long Uid){
		return repo.findCartByUid(Uid);
	}

}
