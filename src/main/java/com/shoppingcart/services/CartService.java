package com.shoppingcart.services;

import org.springframework.stereotype.Service;

import com.shopping.cart.request.ProductRequest;
import com.shopping.cart.response.CartResponse;

@Service
public interface CartService {
	public void addProductToCart(ProductRequest addProduct);

	public void removeProductFromCart(ProductRequest addProduct);

	public void removeAllProductsFromCart(Integer addProduct);

	public void updateQuantityOfTheProduct(ProductRequest addProduct);

	public CartResponse viewCart(Integer userId);

}
