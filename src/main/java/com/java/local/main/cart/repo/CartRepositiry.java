package com.java.local.main.cart.repo;

import com.java.local.main.model.domain.Cart;

public interface CartRepositiry {

	Cart create(Cart cart);

	Cart read(String cartId);

	void update(String cartId, Cart cart);

	void delete(String cartId);

}
