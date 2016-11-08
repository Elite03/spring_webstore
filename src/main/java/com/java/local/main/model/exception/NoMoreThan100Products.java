package com.java.local.main.model.exception;

public class NoMoreThan100Products extends RuntimeException {
	private static final long serialVersionUID = 1L;

	Long products;

	public NoMoreThan100Products(Long products) {
		this.products = products;
	}

	public Long getProducts() {
		return products;
	}
}
