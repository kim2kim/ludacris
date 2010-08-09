package com.ludacris.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ludacris.dao.ProductDao;
import com.ludacris.model.Product;

@Repository("productDao")
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long> implements ProductDao{
	
	public ProductDaoHibernate() {
		super(Product.class);
	}

	public List<Product> findAllProductByCategory(String category, int start){
		Query q = this.getSessionFactory().getCurrentSession().createQuery("FROM Product where category = :category");
		q.setFetchSize(50);
		q.setMaxResults(50);
		q.setFirstResult(start);
		q.setParameter("category", category);
		return (List<Product>)q.list();
	}
	
	public List<Product> findAllProductBySubcategory(String category, String subcategory, int start){
		Query q = this.getSessionFactory().getCurrentSession().createQuery("FROM Product where category = :category and subcategory = :subcategory");
		q.setFetchSize(50);
		q.setMaxResults(50);
		q.setFirstResult(start);
		q.setParameter("category", category);
		q.setParameter("subcategory", subcategory);
		return (List<Product>)q.list();
	}
}
