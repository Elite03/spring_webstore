package com.java.local.main.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.java.local.main.model.domain.Product;

public class ProductValidator implements Validator {

	@Autowired
	private javax.validation.Validator beanValidator;
	private Set<Validator> springValidators;

	public ProductValidator() {
		springValidators = new HashSet<>();
	}

	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Set<ConstraintViolation<Object>> constrainViolations = beanValidator.validate(object);
		for (ConstraintViolation<Object> constraintViolation : constrainViolations) {
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		for (Validator validator : springValidators) {
			validator.validate(object, errors);
		}
	}

}