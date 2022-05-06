package com.shopping.cart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.response.ProductResponse;
import com.shoppingcart.services.ProductService;

@RequestMapping("/product")
@RestController
public class ProdutController {

	@Autowired
	ProductService productService;

	/**
	 * Gettting the product details based on the id
	 * 
	 * @param search
	 * @return
	 */
	@GetMapping("/id/{search}")
	public List<ProductResponse> getProductsById(@PathVariable("search") Integer search) {
		return productService.getProductsById(search);

	}

	/**
	 * Getting the product details based on the name
	 * 
	 * @param search
	 * @return
	 */
	@GetMapping("/name/{search}")
	public List<ProductResponse> getProductsByName(@PathVariable("search") String search) {
		return productService.getProductsByName(search);

	}

}
