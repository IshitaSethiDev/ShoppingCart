package com.shopping.cart.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopping.cart.models.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct, Integer> {
	List<CartProduct> findByProductProductidAndCartId(Integer productId, Integer cartId);

	List<CartProduct> findByCartId(Integer cartId);

}
