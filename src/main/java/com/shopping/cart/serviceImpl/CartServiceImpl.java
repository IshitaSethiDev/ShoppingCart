package com.shopping.cart.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.models.CartProduct;
import com.shopping.cart.models.Product;
import com.shopping.cart.models.User;
import com.shopping.cart.repositories.CartProductRepository;
import com.shopping.cart.repositories.ProductRepository;
import com.shopping.cart.repositories.UserRepository;
import com.shopping.cart.request.ProductRequest;
import com.shopping.cart.response.CartResponse;
import com.shopping.cart.response.ProductResponse;
import com.shoppingcart.services.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	ProductRepository productRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	CartProductRepository cartProductRepo;

	/**
	 * Adding the product to the cart and if the product already added then
	 * incrementing the quantity
	 */
	@Override
	public void addProductToCart(ProductRequest addProduct) {
		Optional<User> userObj = userRepo.findById(addProduct.getUserId());
		List<CartProduct> cartProductsList = cartProductRepo.findByProductProductidAndCartId(addProduct.getProductId(),
				userObj.get().getCart().getId());
		CartProduct cartProductObj = null;
		// if the list is empty means no product is added earlier
		if (cartProductsList.isEmpty()) {
			cartProductObj = new CartProduct();
			cartProductObj.setCart(userObj.get().getCart());
			Optional<Product> productObj = productRepo.findById(addProduct.getUserId());
			cartProductObj.setProduct(productObj.get());
			cartProductObj.setQuantity(1);
		} else {
			cartProductObj = cartProductsList.get(0);
			cartProductObj.setQuantity(cartProductObj.getQuantity() + 1);
		}
		cartProductRepo.save(cartProductObj);
	}

	/**
	 * Removing the product from the cart
	 */
	@Override
	public void removeProductFromCart(ProductRequest addProduct) {
		Optional<User> userObj = userRepo.findById(addProduct.getUserId());
		List<CartProduct> cartProductsList = cartProductRepo.findByProductProductidAndCartId(addProduct.getProductId(),
				userObj.get().getCart().getId());
		CartProduct cartProductObj = cartProductsList.get(0);
		cartProductRepo.delete(cartProductObj);
	}

	/**
	 * Removing all the products associated to the cart
	 */
	@Override
	public void removeAllProductsFromCart(Integer userId) {
		Optional<User> userObj = userRepo.findById(userId);
		List<CartProduct> cartProductsList = cartProductRepo.findByCartId(userObj.get().getCart().getId());
		cartProductRepo.deleteAll(cartProductsList);

	}

	/**
	 * Updating the quantity of the product with the given value and if the quantity
	 * is 0 then removing that product from the cart
	 */
	@Override
	public void updateQuantityOfTheProduct(ProductRequest addProduct) {
		Optional<User> userObj = userRepo.findById(addProduct.getUserId());
		List<CartProduct> cartProductsList = cartProductRepo.findByProductProductidAndCartId(addProduct.getProductId(),
				userObj.get().getCart().getId());
		CartProduct cartProductObj = cartProductsList.get(0);
		if (addProduct.getQuantity() == 0) {
			cartProductRepo.delete(cartProductObj);
		} else {
			cartProductObj.setQuantity(addProduct.getQuantity());
			cartProductRepo.save(cartProductObj);
		}
	}

	/**
	 * Getting the cart details for the user
	 */
	@Override
	public CartResponse viewCart(Integer userId) {
		Optional<User> userObj = userRepo.findById(userId);
		List<CartProduct> cartProductsList = cartProductRepo.findByCartId(userObj.get().getCart().getId());
		CartResponse cartResponse = new CartResponse();

		List<ProductResponse> list = new ArrayList<>();
		double totalAmount = 0.0;
		for (CartProduct cp : cartProductsList) {
			Product p = cp.getProduct();
			ProductResponse pr = new ProductResponse();
			pr.setPrice(p.getPrice());
			pr.setProductId(p.getProductid());
			pr.setProductName(p.getProductName());
			list.add(pr);
			totalAmount = totalAmount + p.getPrice();
		}

		cartResponse.setProductResponse(list);
		cartResponse.setTotalAmount(totalAmount);
		return cartResponse;

	}

}
