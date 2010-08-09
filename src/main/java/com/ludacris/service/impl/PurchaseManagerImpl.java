package com.ludacris.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ludacris.dao.PurchaseDao;
import com.ludacris.model.Purchase;
import com.ludacris.model.User;
import com.ludacris.service.PurchaseManager;

@Service("purchaseManager")
public class PurchaseManagerImpl extends GenericManagerImpl<Purchase, Long> implements PurchaseManager{

	@Autowired
	private PurchaseDao purchaseDao;
	
	public List<Purchase> findAllPurchaseBy(User user, int start){
		return this.purchaseDao.findAllPurchaseBy(user, start);
	}
}
