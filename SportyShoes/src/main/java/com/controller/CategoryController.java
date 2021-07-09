package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.Category;
import com.model.User;
import com.service.CategoryService;

@Controller
@SessionAttributes(names = "user")
@RequestMapping("/sportyshoes")
public class CategoryController {
	
	@Autowired
	private CategoryService cs;
	
	
	@GetMapping("/category")
	public String category(ModelMap map) {
		User user = (User) map.getAttribute("user");
		if(user.isAdminAcc()) {
			map.addAttribute("categories", cs.getAllCategory());
			map.addAttribute("category", new Category());
			return "categories";
		}
		else {
			map.addAttribute("errorMessage", "Accessible only to admin");
			return "home";
		}
		
	}
	
	@PostMapping("/category")
	public String addCategory(ModelMap map, @Valid Category cat, BindingResult result) {
		
		if (result.hasErrors()) {
			return "categories";
		}
		
		cs.addCategory(cat.getCatName());
		
		map.put("successMessage", "Category " +cat.getCatName() + " registered succesfuly");
		return "redirect:category";
	}
	
	@GetMapping("/update-cat")
	public String getCatUpdate(@RequestParam int id, ModelMap model) {
		Category cat = cs.findCat(id);
		model.addAttribute("category", cat);
		model.addAttribute("categories", cs.getAllCategory());
		return "categories";
	}
	
	@PostMapping("/update-cat")
	public String updateUser(ModelMap map, @Valid Category cat, BindingResult result) {
		if(result.hasErrors()) {
			return "categories";
		}
		
		cs.updateCategory(cat);
		return "redirect:category";
	}
	
	@GetMapping("/delete-cat")
	public String getUserDelete(@RequestParam int id, ModelMap model) {
		cs.deleteCategory(id);
		return "redirect:category";
	}
}
