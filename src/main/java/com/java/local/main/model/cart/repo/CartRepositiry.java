package com.java.local.main.model.cart.repo;

import com.java.local.main.model.domain.Cart;

public interface CartRepositiry {

	Cart create(Cart cart);

	Cart read(String cartId);

	void updateCart(String cartId, Cart cart);

	void delectCart(String cartId);

}
