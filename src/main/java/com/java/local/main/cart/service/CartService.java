package com.java.local.main.cart.service;

import com.java.local.main.model.domain.Cart;
import com.java.local.main.model.domain.CartItem;

public interface CartService {
	Cart create(Cart cart);

	Cart read(String cartId);

	void update(String cartId, Cart cart);

	void delete(String cartId);

	void addCartItem(CartItem cartItem);
}
