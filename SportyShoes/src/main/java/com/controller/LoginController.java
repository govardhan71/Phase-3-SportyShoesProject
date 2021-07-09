package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.User;
import com.service.UserService;


@Controller
@SessionAttributes(names = {"user"})
@RequestMapping("/sportyshoes")
public class LoginController {
	
	
	@Autowired
	private UserService us;

	@GetMapping("/login")
	public String login() {
		us.createDefaultAdmin();
		return "login";
	}
	
	
	@PostMapping("/login")
	public String loginValid(ModelMap map,@RequestParam("uname") String name, @RequestParam("upass") String password) {
		if (us.loginValid(name, password)) {
			
			List<User> users = (List<User>) us.loadUsers();
			for(User user : users) {
				if(user.getName().equals(name)){
					if(user.getPassword().equals(password)) {
						map.put("user", user);
					}
				}
			}
			
			map.put("successMessage", "Welcome " + name + " !!!");
			return "home";
		} else {
			map.put("errorMessage", "Login credentials invalid");
			return "login";
		}
	}
	
}
