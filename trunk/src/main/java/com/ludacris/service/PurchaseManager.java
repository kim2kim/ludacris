package com.ludacris.service;

import java.util.List;

import com.ludacris.model.Purchase;
import com.ludacris.model.User;

public interface PurchaseManager extends GenericManager<Purchase, Long>{
	public List<Purchase> findAllPurchaseBy(User user, int start);
}
