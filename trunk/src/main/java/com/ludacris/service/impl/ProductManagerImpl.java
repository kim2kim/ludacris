package com.ludacris.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ludacris.dao.ProductDao;
import com.ludacris.model.Product;
import com.ludacris.service.ProductManager;

@Service("productManager")
public class ProductManagerImpl extends GenericManagerImpl<Product, Long> implements ProductManager{

	@Autowired
	private ProductDao productDao;
	
	public List<Product> findAllProductByCategory(String category, int start) {
		return this.productDao.findAllProductByCategory(category, start);
	}

	public List<Product> findAllProductBySubcategory(String category, String subcategory,
			int start) {
		return this.productDao.findAllProductBySubcategory(category, subcategory, start);
	}

}
