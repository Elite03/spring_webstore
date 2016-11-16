package com.java.local.main.cart.repo.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.java.local.main.cart.repo.CartRepositiry;
import com.java.local.main.model.domain.Cart;

@Repository
public class CartRepositiryImpl implements CartRepositiry {

	private Map<String, Cart> listOfCarts;

	public CartRepositiryImpl() {
		listOfCarts = new HashMap<>();
	}

	@Override
	public Cart create(Cart cart) {
		if (listOfCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(
					String.format("Cannot create Cart. Cart with given Id (%s) already exists", cart.getCartId()));
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if (!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format("Cannot Update Cart as Cart with given Id (%s) does not exists", cartId));
		}
		listOfCarts.put(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		if (!listOfCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format("Cannot Delete as Item with Id (%s) does not exists", cartId));
		}
	}

}
