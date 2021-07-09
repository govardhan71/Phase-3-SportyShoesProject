package com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.model.Purchase;
import com.model.User;
import com.repo.PurchaseRepo;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepo purRepo;

	public void addPurchase(User user, Product purchase, int purchaseCount) {
		Date date = new Date();
		purRepo.save(new Purchase(purchase, user, purchaseCount, date));

	}

	public List<Purchase> getAllPurchase() {
		return (List<Purchase>) purRepo.findAll();
	}

	public List<Purchase> getUserPurchase(User user) {
		List<Purchase> pur = this.getAllPurchase();
		List<Purchase> purSpecific = new ArrayList<Purchase>();
		for (Purchase purchase : pur) {
			if (purchase.getUser().getId().equals(user.getId())) {
				purSpecific.add(purchase);
			}
		}
		return purSpecific;
	}

	public List<Purchase> filterPurchases(int uid, int cid, String pdate, User user) {
		List<Purchase> purchases = new ArrayList<Purchase>();
		if (user.isAdminAcc()) {
			purchases = this.getAllPurchase();
		} else {
			purchases = this.getUserPurchase(user);
		}

		List<Purchase> filter = new ArrayList<Purchase>();
		// filter by user uid.
		if (uid == 0) {
			filter = purchases;
		} else {
			for (Purchase purchase : purchases) {
				if (purchase.getUser().getId().equals(uid)) {
					filter.add(purchase);
				}
			}
		}

		List<Purchase> filter1 = new ArrayList<Purchase>();
		// filter by user cid.
		if (cid == 0) {
			filter1 = filter;
		} else {
			for (Purchase purchase : filter) {
				int pc_Id = purchase.getPurchase().getProdCategory().getCatId();
				if (pc_Id == cid) {
					filter1.add(purchase);
				}
			}
		}

		// filter by user pdate.
		List<Purchase> filter2 = new ArrayList<Purchase>();
		if (pdate.equals(null) || pdate.equals("")) {
			filter2 = filter1;
		} else {
			for (Purchase purchase : filter1) {
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				Date date = purchase.getDate();
				String purchaseDate = formatter.format(date);

				if (purchaseDate.equals(pdate)) {
					filter2.add(purchase);
				}
			}
		}
		return filter2;
	}

}
