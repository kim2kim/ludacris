package com.ludacris.service;

import java.util.List;

import com.ludacris.model.Product;

public interface ProductManager extends GenericManager<Product, Long>{
	List<Product> findAllProductByCategory(String category, int start);
	List<Product> findAllProductBySubcategory(String category,String subcategory, int start);
}
