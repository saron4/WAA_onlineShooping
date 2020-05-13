package com.group3.onlineShooping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products found under this category.")
public class NoProductsFoundUnderCategoryException extends RuntimeException {

	private static final long serialVersionUID = 1554251630974234515L;

	private String message;

	public NoProductsFoundUnderCategoryException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
