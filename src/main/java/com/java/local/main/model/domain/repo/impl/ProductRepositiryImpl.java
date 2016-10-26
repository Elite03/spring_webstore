package com.java.local.main.model.domain.repo.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.java.local.main.model.domain.Product;
import com.java.local.main.model.domain.repo.ProductRepositiry;

@Repository
public class ProductRepositiryImpl implements ProductRepositiry {

	private List<Product> productList;

	public ProductRepositiryImpl() {
		productList = new ArrayList<>();

		Product iPhome = new Product();
		iPhome.setProductId("P1234");
		iPhome.setName("iPhone");
		iPhome.setUnitPrice(new BigDecimal(399));
		iPhome.setDescription("Apple iPhone 6s smartphone with 5.5-inch 640x1136 display and 8-megapixel rear camera");
		iPhome.setCategory("Smart Phone");
		iPhome.setManufacturer("Apple");
		iPhome.setUnitsInStock(1000);

		Product laptopDell = new Product();
		laptopDell.setProductId("P1235");
		laptopDell.setName("Dell Inspiron");
		laptopDell.setUnitPrice(new BigDecimal(799));
		laptopDell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 5th Generation Intel Core processors");
		laptopDell.setCategory("laptop");
		laptopDell.setManufacturer("Dell");
		laptopDell.setUnitsInStock(1000);

		Product tablet = new Product();
		tablet.setName("Nexus 7");
		tablet.setProductId("P12346");
		tablet.setUnitPrice(new BigDecimal(599));
		tablet.setDescription(
				"Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
		tablet.setCategory("Tablet");
		tablet.setManufacturer("Google");
		tablet.setUnitsInStock(1000);

		productList.add(iPhome);
		productList.add(laptopDell);
		productList.add(tablet);
	}

	@Override
	public List<Product> getAllProducts() {
		return productList;
	}

	@Override
	public Product getProductById(String productId) {

		return productList.stream()
				.filter(product -> product != null && product.getProductId() != null
						&& product.getProductId().equals(productId))
				.findFirst().orElseThrow(() -> new IllegalStateException("Product not found with id " + productId));
	}

	@Override
	public List<Product> getProductByCategory(String productCategory) {
		return productList.stream().filter(product -> product.getCategory().equalsIgnoreCase(productCategory))
				.collect(Collectors.toList());
	}

}
