package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

}
