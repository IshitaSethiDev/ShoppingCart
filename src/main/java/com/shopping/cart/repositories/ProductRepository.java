package com.shopping.cart.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shopping.cart.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findAllByProductid(Integer id);

	List<Product> findAllByProductNameContaining(String name);

	Optional<Product> findById(Integer id);

}
