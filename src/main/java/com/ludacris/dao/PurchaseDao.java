package com.ludacris.dao;

import java.util.List;

import com.ludacris.model.Purchase;
import com.ludacris.model.User;

public interface PurchaseDao extends GenericDao<Purchase, Long>{

	public List<Purchase> findAllPurchaseBy(User user, int start);
}
