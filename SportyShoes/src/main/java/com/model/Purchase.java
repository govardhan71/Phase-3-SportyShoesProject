package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchaseId;
	
	@ManyToOne
	@JoinColumn
	private Product purchase;
	
	@ManyToOne
	@JoinColumn
	private User user;
	private int purchaseCount;
	private Date date;
	
	
	
	public int getPurchaseCount() {
		return purchaseCount;
	}

	public void setPurchaseCount(int purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Product getPurchase() {
		return purchase;
	}

	public void setPurchase(Product purchase) {
		this.purchase = purchase;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchase(Product purchase, User user, int purchaseCount, Date date) {
		super();
		this.purchase = purchase;
		this.user = user;
		this.purchaseCount = purchaseCount;
		this.date = date;
	}

	

}
