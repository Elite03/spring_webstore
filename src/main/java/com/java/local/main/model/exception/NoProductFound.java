package com.java.local.main.model.exception;

public class NoProductFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public NoProductFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
