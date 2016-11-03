package com.java.local.main.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.local.main.model.domain.Product;
import com.java.local.main.model.domain.service.ProductService;
import com.java.local.main.model.exception.NoProductFound;

public class ProductIdValidator implements ConstraintValidator<ProductId, String> {

	@Autowired
	private ProductService productService;

	@Override
	public void initialize(ProductId productId) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		Product product;
		try {
			product = productService.getProductById(value);
		} catch (NoProductFound ex) {
			return true;
		}
		return product != null ? false : true;
	}

}
