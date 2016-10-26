package com.java.local.main.model.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.local.main.model.domain.Product;
import com.java.local.main.model.domain.repo.ProductRepositiry;
import com.java.local.main.model.domain.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepositiry productRepositiry;

	@Override
	public List<Product> getAllProducts() {
		return productRepositiry.getAllProducts();
	}

	@Override
	public Product getProductById(String productId) {
		return productRepositiry.getProductById(productId);
	}

	@Override
	public List<Product> getProductByCategory(String productCategory) {
		return productRepositiry.getProductByCategory(productCategory);
	}

}
