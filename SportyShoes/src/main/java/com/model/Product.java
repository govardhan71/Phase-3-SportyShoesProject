package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prodId;
	
	private String prodName;
	
	private int stock;
	
	@ManyToOne
	@JoinColumn
	private Category prodCategory;
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Category getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(Category prodCategory) {
		this.prodCategory = prodCategory;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String prodName, Category prodCategory) {
		super();
		this.prodName = prodName;
		this.prodCategory = prodCategory;
	}

	public Product(String prodName, Category prodCategory, int stock) {
		super();
		this.prodName = prodName;
		this.prodCategory = prodCategory;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", stock=" + stock + ", prodCategory="
				+ prodCategory + "]";
	}

}
