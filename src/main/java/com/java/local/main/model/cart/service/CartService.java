package com.java.local.main.model.cart.service;

import com.java.local.main.model.domain.Cart;

public interface CartService {

	Cart create(Cart cart);

	Cart read(String cartid);

	void update(String cartId, Cart cart);

	void delete(String cartId);
}
