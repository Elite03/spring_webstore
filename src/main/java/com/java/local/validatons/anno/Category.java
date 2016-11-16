package com.java.local.validatons.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.java.local.validatons.anno.validators.CategoryValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Documented
@Constraint(validatedBy = CategoryValidator.class)
public @interface Category {
	String message() default "{Category.Constraint.Validator.validation}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};
}
