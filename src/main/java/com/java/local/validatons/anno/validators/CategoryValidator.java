package com.java.local.validatons.anno.validators;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.java.local.main.model.exception.NoProductFound;
import com.java.local.validatons.anno.Category;

public class CategoryValidator implements ConstraintValidator<Category, String> {

	@Override
	public void initialize(Category constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<String> rejectedCategory = Arrays.asList("toy", "crockery", "cloth");
		try {
			if (rejectedCategory.contains(value)) {
				return false;
			}
		} catch (NoProductFound ex) {
			return true;
		}
		return true;
	}

}
