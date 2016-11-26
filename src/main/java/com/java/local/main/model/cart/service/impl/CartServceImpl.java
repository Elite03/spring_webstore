package com.java.local.main.model.cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.local.main.model.cart.repo.CartRepositiry;
import com.java.local.main.model.cart.service.CartService;
import com.java.local.main.model.domain.Cart;

@Service
public class CartServceImpl implements CartService {

	@Autowired
	private CartRepositiry cartRepositiry;

	@Override
	public Cart create(Cart cart) {
		return cartRepositiry.create(cart);
	}

	@Override
	public Cart read(String cartid) {
		return cartRepositiry.read(cartid);
	}

	@Override
	public void update(String cartId, Cart cart) {
		cartRepositiry.updateCart(cartId, cart);

	}

	@Override
	public void delete(String cartId) {
		cartRepositiry.delectCart(cartId);

	}

}
