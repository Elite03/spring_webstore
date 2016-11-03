package com.java.local.main.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.java.local.main.model.domain.Product;

@Component
public class UnitsInStockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Product product = (Product) object;
		if (product.getUnitPrice() != null && new BigDecimal(10000).compareTo(product.getUnitPrice()) <= 0
				&& product.getUnitsInStock() > 99)
			errors.rejectValue("unitsInStock", "com.webstore.validator.UnitsInStockValidator.message");
	}

}
