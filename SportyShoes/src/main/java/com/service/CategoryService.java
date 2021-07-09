package com.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.repo.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo catRepo;
	
	public void addCategory(String catName) {
		catRepo.save(new Category(catName));
	}

	public List<Category> getAllCategory() {
		return (List<Category>) catRepo.findAll();
	}


	public void updateCategory(@Valid Category cat1) {
		Integer id =cat1.getCatId();
		Optional<Category> catUp = catRepo.findById(id);
		if(catUp.isPresent()) {
			Category catUpdated = catUp.get();
			catUpdated.setCatName(cat1.getCatName());
			catRepo.save(catUpdated);
		}
		
	}

	public void deleteCategory(int id) {
		catRepo.deleteById(id);
	}

	public Category findCat(int id) {
		Category cat = null;
		Optional<Category> category = catRepo.findById(id);
		if (category.isPresent()) {
			cat = category.get();
		}
		return cat;
	}
	
}
