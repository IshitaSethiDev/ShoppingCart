package com.shoppingcart.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.cart.response.ProductResponse;

@Service
public interface ProductService {
	public List<ProductResponse> getProductsById(Integer search);
	public List<ProductResponse> getProductsByName(String search);

}

