package com.java.local.main.model.domain.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.local.main.model.domain.Product;

@Repository
public interface ProductRepositiry {
	List<Product> getAllProducts();

	Product getProductById(String productId);

	List<Product> getProductByCategory(String productCategory);
}
