package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(names = {"user"})
@RequestMapping("/sportyshoes")
public class HomeController {

		@GetMapping("/home")
		public String home() {
			return "home";
		}
		
}
