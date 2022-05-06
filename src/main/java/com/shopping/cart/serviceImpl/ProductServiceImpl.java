package com.shopping.cart.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.models.Product;
import com.shopping.cart.repositories.ProductRepository;
import com.shopping.cart.response.ProductResponse;
import com.shoppingcart.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepo;

	/**
	 * Getting the product details based on the product Id
	 */
	@Override
	public List<ProductResponse> getProductsById(Integer search) {
		List<Product> products = productRepo.findAllByProductid(search);
		List<ProductResponse> list = new ArrayList<>();
		for (Product p : products) {
			ProductResponse pr = new ProductResponse();
			pr.setPrice(p.getPrice());
			pr.setProductId(p.getProductid());
			pr.setProductName(p.getProductName());
			list.add(pr);
		}
		return list;
	}

	/**
	 * Getting the product details based on the product name
	 */
	@Override
	public List<ProductResponse> getProductsByName(String search) {
		List<Product> products = productRepo.findAllByProductNameContaining(search);
		List<ProductResponse> list = new ArrayList<>();
		for (Product p : products) {
			ProductResponse pr = new ProductResponse();
			pr.setPrice(p.getPrice());
			pr.setProductId(p.getProductid());
			pr.setProductName(p.getProductName());
			list.add(pr);
		}
		return list;
	}

}
