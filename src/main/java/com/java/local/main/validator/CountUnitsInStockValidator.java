package com.java.local.main.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.java.local.main.model.domain.Product;

public class CountUnitsInStockValidator implements ConstraintValidator<UnitsInStock, Long> {

	@Override
	public void initialize(UnitsInStock unitsInStock) {

	}

	@Override
	public boolean isValid(Long totalCount, ConstraintValidatorContext constraintValidatorContext) {
		Product product;
		
		return false;
	}

}
