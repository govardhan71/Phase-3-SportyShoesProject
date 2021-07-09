package com.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.model.Product;
import com.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo prodRepo;
	
	public void addProdcut(String prodName, Category prodCategory, int stock) {
		prodRepo.save(new Product(prodName, prodCategory, stock));
	}
	
	public List<Product> getAllProduct(){
		return  (List<Product>) prodRepo.findAll();
	}
	
	
	public void updateProduct(int id2, String name, Category cat, int stock) {
		Integer id =id2;
		Optional<Product> prodUp = prodRepo.findById(id);
		if(prodUp.isPresent()) {
			Product prodUpdated = prodUp.get();
			prodUpdated.setProdName(name);
			prodUpdated.setProdCategory(cat);
			prodUpdated.setStock(stock);
			prodRepo.save(prodUpdated);
		}
		
	}

	public Product findProd(int id) {
		Product prod = null;
		Optional<Product> product = prodRepo.findById(id);
		if(product.isPresent()) {
			prod = product.get();
		}
		return prod;
	}
	
	public void deleteProduct(int id) {
		prodRepo.deleteById(id);
	}

	public void updateProductStock(Product pd, int count) {
		int newStock = pd.getStock()-count;
		pd.setStock(newStock);
		prodRepo.save(pd);
		
	}

	public boolean checkAvailablitiy(Product pd, int count) {
		return (pd.getStock() >= count);
	}
}
