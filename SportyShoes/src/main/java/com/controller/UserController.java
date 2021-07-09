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

import com.model.User;
import com.service.UserService;

@Controller
@SessionAttributes(names = "user")
@RequestMapping("/sportyshoes")
public class UserController {

	@Autowired
	private UserService us;

	@GetMapping("/register")
	public String register(ModelMap map) {
		User user = (User) map.getAttribute("user");
		if (user.isAdminAcc()) {
			map.addAttribute("user", new User());
			return "registration";
		} else {
			map.addAttribute("errorMessage", "Accessible only to admin");
			return "home";
		}
	}

	@PostMapping("/register")
	public String addUser(ModelMap map, @Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "registration";
		}
		us.registerUser(user.getName(), user.getPassword(), user.getCity(), user.getEmail(), user.isAdminAcc());
		map.put("successMessage", "User " + user.getName() + " registered succesfuly");
		return "redirect:listUsers";

	}

	@GetMapping("/listUsers")
	public String loadAll(ModelMap map) {
		map.put("userList", us.loadUsers());
		return "listUsers";
	}

	@PostMapping("/listUsers")
	public String loadRequested(ModelMap map, @RequestParam("uname") String name) {

		if (name.equals(null)) {
			map.put("userList", us.loadUsers());
		} else {
			map.put("userList", us.findParticular(name));
		}
		return "listUsers";
	}

	@GetMapping(value = "/update-user")
	public String getUserUpdate(@RequestParam int id, ModelMap model) {
		User user = us.findWithID(id);
		model.addAttribute("user", user);
		return "registration";
	}

	@PostMapping(value = "/update-user")
	public String updateUser(ModelMap map, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "registration";
		}

		us.updateUser(user);
		return "redirect:listUsers";
	}

	@GetMapping(value = "/delete-user")
	public String getUserDelete(@RequestParam int id, ModelMap model) {
		us.deleteUser(id);
		return "redirect:listUsers";
	}

	@GetMapping(value = "/changepass")
	public String getChangePass(ModelMap map) {
		return "changepass";
	}

	@PostMapping(value = "/changepass")
	public String changePass(@RequestParam("oldpass") String curPass, @RequestParam("NewPass") String newPass,
			@RequestParam("confPass") String confPass, ModelMap model) {
		User user = (User) model.getAttribute("user");
		if (newPass.equals(confPass)) {
			if (us.changePass(user, curPass, newPass)) {
				return "redirect:Logout";
			} else {
				model.addAttribute("errorMessage", "Password mismatch");
			}
			return "changepass";
		} else {
			model.addAttribute("errorMessage", "New and confirm password mismatch");
			return "changepass";
		}

	}

}
