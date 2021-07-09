package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {

}
