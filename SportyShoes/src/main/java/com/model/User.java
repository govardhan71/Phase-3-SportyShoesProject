package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(unique = true)
	private String name;
	
	@NotEmpty
	private String password;
	
	private boolean adminAcc;
	
	private String city;
	private String email;
	
	
	
	public boolean isAdminAcc() {
		return adminAcc;
	}

	public void setAdminAcc(boolean adminAcc) {
		this.adminAcc = adminAcc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email=" + email + ", city=" + city + "]";
	}

	

	public User(@NotEmpty String name, @NotEmpty String password, String email, String city, boolean adminAcc) {
		super();
		this.name = name;
		this.password = password;
		this.adminAcc = adminAcc;
		this.city = city;
		this.email = email;
	}

	public User() {
		super();
	}



}
