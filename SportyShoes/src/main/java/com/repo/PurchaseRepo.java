package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Purchase;
@Repository
public interface PurchaseRepo extends CrudRepository<Purchase, Integer> {

}
