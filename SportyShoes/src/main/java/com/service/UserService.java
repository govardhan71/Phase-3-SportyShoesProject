package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo myRepo;

	public boolean loginValid(String name, String password) {

		List<User> users = (List<User>) myRepo.findAll();
		for (User user : users) {
			if (user.getName().equals(name)) {
				if (user.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	public void registerUser(String name, String password, String city, String email, boolean adminAcc) {
		myRepo.save(new User(name, password, city, email, adminAcc));

	}

	public List<User> loadUsers() {
		return (List<User>) myRepo.findAll();
	}

	public List<User> findParticular(String name) {
		List<User> all = (List<User>) myRepo.findAll();
		List<User> particular = new ArrayList<User>();

		if (all.size() > 0) {
			for (User us : all) {
				if (us.getName().equals(name)) {
					particular.add(us);
				}
			}
		}
		return particular;
	}

	public User findWithID(int id) {
		User us1 = null;
		Optional<User> user = myRepo.findById(id);
		if (user.isPresent()) {
			us1 = user.get();
		}
		return us1;
	}

	public void updateUser(@Valid User user) {
		Integer id = user.getId();
		Optional<User> userToBeUpdated = myRepo.findById(id);
		if (userToBeUpdated.isPresent()) {
			User user1 = userToBeUpdated.get();
			user1.setName(user.getName());
			user1.setPassword(user.getPassword());
			user1.setCity(user.getCity());
			user1.setEmail(user.getEmail());
			user1.setAdminAcc(user.isAdminAcc());
			myRepo.save(user1);
		}

	}

	public void deleteUser(int id) {
		myRepo.deleteById(id);
	}

	public void createDefaultAdmin() {
		Optional<User> user = myRepo.findById(1);
		if (!user.isPresent()) {
			User defUser = new User();
			defUser.setName("admin");
			defUser.setPassword("major");
			defUser.setAdminAcc(true);

			myRepo.save(defUser);
		}
	}

	public boolean changePass(User user, String curPass, String newPass) {
		if(user.getPassword().equals(curPass)) {
			user.setPassword(newPass);
			myRepo.save(user);
			return true;
		}
		return false;
	}

}
