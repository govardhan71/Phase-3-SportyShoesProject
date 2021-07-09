package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"user"})
@RequestMapping("/sportyshoes")
public class LogoutController {
	
	@GetMapping("/Logout")
	public String getPurchasePage(ModelMap map) {
		map.clear();
		return "redirect:login";
	}
}
