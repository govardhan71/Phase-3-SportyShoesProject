package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.Category;
import com.model.Product;
import com.model.User;
import com.service.CategoryService;
import com.service.ProductService;

@Controller
@SessionAttributes(names = "user")
@RequestMapping("/sportyshoes")
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private CategoryService cs;
	
	@GetMapping("/manageProducts")
	public String getAddProduct(ModelMap map) {
		User user = (User) map.getAttribute("user");
		if(user.isAdminAcc()) {
			map.addAttribute("listCategory",cs.getAllCategory());
			map.addAttribute("productList",ps.getAllProduct());
			return "products";
		}
		else {
			map.addAttribute("errorMessage", "Accessible only to admin");
			return "home";
		}
		
	}
	
	@PostMapping("/manageProducts")
	public String addProduct(ModelMap map,@RequestParam("prodStock") int stock, @RequestParam("prodName") String name, @RequestParam("prodCategory") int catId) {
		Category cat = cs.findCat(catId);

		if(name.equals(null)||name.equals("")) {
			map.addAttribute("errorMessage", "Name should not be null");
			return "products";
		}
		
		Product prod = new Product(name, cat, stock);
		map.addAttribute("errorMessage", null);
		ps.addProdcut(prod.getProdName(), prod.getProdCategory(), prod.getStock());
		map.put("successMessage", "Product " +prod.getProdName() + " registered succesfuly");
		
		return "redirect:manageProducts";
	}
	
	@GetMapping("/update-prod")
	public String getUpdateProductPage(@RequestParam int id, ModelMap map) {
		map.addAttribute("listCategory",cs.getAllCategory());
		map.addAttribute("productList",ps.getAllProduct());
		Product prod = ps.findProd(id);
		map.addAttribute("productName", prod.getProdName());
		map.addAttribute("selectedCatId",prod.getProdCategory().getCatId());
		map.addAttribute("productStock", prod.getStock());
		return "products";
	}
	
	@PostMapping("/update-prod")
	public String updateProduct(ModelMap map,@RequestParam("id") int id,@RequestParam("prodStock") int stock, @RequestParam("prodName") String name, @RequestParam("prodCategory") int catId) {
		Category cat = cs.findCat(catId);
		
		if(name.equals(null)||name.equals("")) {
			map.addAttribute("errorMessage", "Name should not be null");
			return "products";
		}
		
	
		map.addAttribute("errorMessage", null);
		map.addAttribute("productName", null);
		map.addAttribute("selectedCatId",0);
		map.addAttribute("productStock", "");
		ps.updateProduct(id,name,cat,stock);
		
		return "redirect:manageProducts";
		
	}
	
	@GetMapping("/delete-prod")
	public String getProductDelete(@RequestParam int id, ModelMap model) {
		ps.deleteProduct(id);
		return "redirect:manageProducts";
	}
}
