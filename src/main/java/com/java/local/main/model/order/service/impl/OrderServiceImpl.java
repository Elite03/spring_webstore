package com.java.local.main.model.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.local.main.model.domain.Product;
import com.java.local.main.model.domain.repo.ProductRepositiry;
import com.java.local.main.model.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	ProductRepositiry productRepositiry;

	@Override
	public void processOrder(String prodcutId, long quantity) {
		Product productById = productRepositiry.getProductById(prodcutId);
		if (productById.getUnitsInStock() < quantity)
			throw new IllegalArgumentException("Out of Stock " + prodcutId);
		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);

	}

}
