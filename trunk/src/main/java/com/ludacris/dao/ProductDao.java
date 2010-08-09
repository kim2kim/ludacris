package com.ludacris.dao;

import java.util.List;

import com.ludacris.model.Product;

public interface ProductDao extends GenericDao<Product, Long> {
	List<Product> findAllProductByCategory(String category, int start);
	List<Product> findAllProductBySubcategory(String category, String subcategory, int start);
}
