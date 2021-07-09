package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catId;
	
	@NotEmpty
	private String catName;
	

	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
	public Category() {
		super();
	}
	
	public Category(String catName) {
		super();
		this.catName = catName;
	}
	
}
