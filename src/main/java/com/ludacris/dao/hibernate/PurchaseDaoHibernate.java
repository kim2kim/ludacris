package com.ludacris.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ludacris.dao.PurchaseDao;
import com.ludacris.model.Purchase;
import com.ludacris.model.User;

@Repository("purchaseDao")
public class PurchaseDaoHibernate extends GenericDaoHibernate<Purchase, Long> implements PurchaseDao{

	public PurchaseDaoHibernate() {
		super(Purchase.class);
	}

	public List<Purchase> findAllPurchaseBy(User user, int start){
		Query q = this.getSessionFactory().getCurrentSession().createQuery("FROM Purchase where user = :user");

		q.setFetchSize(50);
		q.setMaxResults(50);
		q.setFirstResult(start);
		q.setParameter("user", user);
		return (List<Purchase>) q.list();
	}

}
