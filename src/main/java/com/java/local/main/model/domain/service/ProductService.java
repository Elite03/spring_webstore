package com.java.local.main.model.domain.service;

import java.util.List;

import com.java.local.main.model.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(String productId);

	List<Product> getProductByCategory(String productCategory);
}
