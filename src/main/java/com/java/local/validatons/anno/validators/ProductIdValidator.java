package com.java.local.validatons.anno.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.local.main.model.domain.service.ProductService;
import com.java.local.main.model.exception.NoProductFound;
import com.java.local.validatons.anno.ProductId;

public class ProductIdValidator implements ConstraintValidator<ProductId, String> {

	@Autowired
	private ProductService productService;

	@Override
	public void initialize(ProductId constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			return productService.getProductById(value) != null ? false : true;
		} catch (NoProductFound ex) {
			return true;
		}
	}

}
