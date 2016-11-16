package com.java.local.main.cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.local.main.cart.repo.CartRepositiry;
import com.java.local.main.model.domain.Cart;

@Service
public class CartServiceImpl implements CartRepositiry {

	@Autowired
	private CartRepositiry cartRepositiry;

	@Override
	public Cart create(Cart cart) {
		return cartRepositiry.create(cart);
	}

	@Override
	public Cart read(String cartId) {
		return cartRepositiry.read(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		cartRepositiry.update(cartId, cart);

	}

	@Override
	public void delete(String cartId) {
		cartRepositiry.delete(cartId);
	}

}
