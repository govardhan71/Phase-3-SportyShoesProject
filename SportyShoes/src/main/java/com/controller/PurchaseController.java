package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.Product;
import com.model.User;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.PurchaseService;
import com.service.UserService;

@Controller
@SessionAttributes(names = {"user"})
@RequestMapping("/sportyshoes")
public class PurchaseController {
	
	@Autowired
	private PurchaseService pr;
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private CategoryService cs;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@GetMapping("/purchase")
	public String getPurchasePage(ModelMap map) {
		map.addAttribute("listProduct", ps.getAllProduct());
		return "purchase";
	}
	
	@PostMapping("/purchase")
	public String addPurchase(ModelMap map,@RequestParam("product")int pid, @RequestParam("purchaseCount")int count ) {
		Product pd = ps.findProd(pid);
		User user = (User) map.get("user");
		if(!ps.checkAvailablitiy(pd,count)) {
			map.addAttribute("errorMessage", "Purchase could not be made");
			return "purchase";
		}
		
		pr.addPurchase(user,pd,count);
		ps.updateProductStock(pd,count);
		
		map.put("successMessage", "Purchase made succesfuly");
		
		return "redirect:purchaseList";
		
		
	}
	
	@GetMapping("/purchaseList")
	public String getPurchaseListPage(ModelMap map) {
		User user = (User) map.getAttribute("user");
		map.addAttribute("listCategory",cs.getAllCategory());
		if(user.isAdminAcc()) {
			map.addAttribute("listUsers",us.loadUsers());
			map.addAttribute("purchaseList", pr.getAllPurchase());
		}
		else {
			List<User> userList = new ArrayList<User>();
			userList.add(us.findWithID(user.getId()));
			map.addAttribute("listUsers",userList);
			map.addAttribute("purchaseList", pr.getUserPurchase(user));
		}
		
		return "purchaselist";
	}
	
	@PostMapping("/purchaseList")
	public String getPurchaseList(ModelMap map,@RequestParam("username")int uid,@RequestParam("productCategory")int cid,@RequestParam("purchaseDate")String pdate) {
		User user = (User)map.getAttribute("user");
		map.addAttribute("listCategory",cs.getAllCategory());
		if(user.isAdminAcc()) {
			map.addAttribute("listUsers",us.loadUsers());
		}
		else {
			List<User> userList = new ArrayList<User>();
			userList.add(us.findWithID(user.getId()));
			map.addAttribute("listUsers",userList);
		}
		
		map.addAttribute("purchaseList", pr.filterPurchases(uid,cid,pdate, user));
		
		return "purchaselist";
	}
}
