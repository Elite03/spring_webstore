package com.java.local.main.model.cart.repo.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.local.main.model.cart.repo.CartRepositiry;
import com.java.local.main.model.domain.Cart;

@Repository
public class CartRepositiryImpl implements CartRepositiry {

	private Map<String, Cart> listOfCarts;

	public CartRepositiryImpl() {
		this.listOfCarts = new HashMap<>();
	}

	@Override
	public Cart create(Cart cart) {
		if (listOfCarts.containsKey(cart.getCartId())) {
			throw new IllegalArgumentException("Cannot Create Cart as already exits with same Id");
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	@Override
	public void updateCart(String cartId, Cart cart) {
		if (!listOfCarts.containsKey(cartId)) {
			throw new IllegalArgumentException("No cart Exists with provided details");
		}
		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delectCart(String cartId) {
		if (!listOfCarts.containsKey(cartId))
			throw new IllegalArgumentException("NO cart exists ");
		listOfCarts.remove(cartId);
	}

}
