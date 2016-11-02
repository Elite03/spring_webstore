package com.java.local.main.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "NO Product found under this category")
public class NoProductFoundUnderCategory extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
