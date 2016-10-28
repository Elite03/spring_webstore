package com.java.local.main.model.domain.repo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.java.local.main.model.domain.Product;

@Repository
public interface ProductRepositiry {
	List<Product> getAllProducts();

	Product getProductById(String productId);

	List<Product> getProductByCategory(String productCategory);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

	void addProduct(Product product);
}
