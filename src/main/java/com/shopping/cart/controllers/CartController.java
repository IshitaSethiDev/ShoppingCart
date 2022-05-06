package com.shopping.cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.request.ProductRequest;
import com.shopping.cart.response.CartResponse;
import com.shoppingcart.services.CartService;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	CartService cartService;

	/**
	 * Adding product to the cart
	 * 
	 * @param addProductRequest
	 */
	@PostMapping("add")
	public void addProductToCart(@RequestBody ProductRequest addProductRequest) {
		cartService.addProductToCart(addProductRequest);

	}

	/**
	 * Removing the product from the cart based on the productid and cartid
	 * 
	 * @param productRequest
	 */
	@DeleteMapping("remove")
	public void removeProductFromCart(@RequestBody ProductRequest productRequest) {
		cartService.removeProductFromCart(productRequest);

	}

	/**
	 * Removing all the products from the cart based on the userId
	 * 
	 * @param userId
	 */
	@DeleteMapping("removeall/{userId}")
	public void removeAllProductsFromCart(@PathVariable("userId") Integer userId) {
		cartService.removeAllProductsFromCart(userId);

	}

	/**
	 * Updating the quantity of the product in the cart
	 * 
	 * @param updateProductRequest
	 */
	@PutMapping("update-quantity")
	public void updateQuantityOfTheProduct(@RequestBody ProductRequest updateProductRequest) {
		cartService.updateQuantityOfTheProduct(updateProductRequest);

	}

	/**
	 * Getting the cart details based on the userId
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("view-cart/{userId}")
	public CartResponse viewCart(@PathVariable("userId") Integer userId) {
		return cartService.viewCart(userId);

	}

}
