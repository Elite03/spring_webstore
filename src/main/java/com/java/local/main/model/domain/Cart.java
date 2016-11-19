package com.java.local.main.model.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private String cartId;
	private Map<String, CartItem> cartItems;
	private BigDecimal grandTotal;

	public Cart() {
		cartItems = new HashMap<>();
		grandTotal = new BigDecimal(0);
	}

	public Cart(String cartId) {
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CartItem item) {
		String productId = item.getProduct().getProductId();
		if (this.cartItems.containsKey(productId)) {
			CartItem existingCartItem = cartItems.get(productId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			this.cartItems.put(productId, existingCartItem);
		} else
			this.cartItems.put(productId, item);

		this.updateGrandTotal();
	}

	public void removeCartItem(CartItem item) {
		if (this.cartItems.containsKey(item.getProduct().getProductId()))
			cartItems.remove(item);
		this.updateGrandTotal();
	}

	public void updateGrandTotal() {
		this.grandTotal = new BigDecimal(0);
		for (CartItem item : this.cartItems.values()) {
			grandTotal = grandTotal.add(item.getToatlPrice());
		}
	}

}
