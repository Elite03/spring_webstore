package com.java.local.validatons.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.java.local.validatons.anno.validators.ProductIdValidator;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductIdValidator.class)
public @interface ProductId {

	String message()

	default "{com.validaions.ProductId}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};

}
