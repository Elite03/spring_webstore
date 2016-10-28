package com.java.local.main.model.domain.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.java.local.main.model.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(String productId);

	List<Product> getProductByCategory(String productCategory);

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
