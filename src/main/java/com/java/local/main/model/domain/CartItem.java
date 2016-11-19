package com.java.local.main.model.domain;

import java.math.BigDecimal;

public class CartItem {

	protected Product product;
	protected int quantity;
	protected BigDecimal toatlPrice;

	public CartItem() {
	}

	public CartItem(Product product) {
		this.product = product;
		this.quantity = 1;
		this.toatlPrice = product.getUnitPrice();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		this.updateTotalPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}

	public BigDecimal getToatlPrice() {
		return toatlPrice;
	}

	public void setToatlPrice(BigDecimal toatlPrice) {
		this.toatlPrice = toatlPrice;
		this.updateTotalPrice();
	}

	public void updateTotalPrice() {
		this.toatlPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
	}

}
