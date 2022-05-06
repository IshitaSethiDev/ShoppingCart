package com.shopping.cart.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shopping.cart.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findById(Integer id);

}
