package com.java.local.main.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.FIELD })
@Documented
public @interface ProductId {
	String message() default "{com.webstore.ProductId.Message}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};
}
