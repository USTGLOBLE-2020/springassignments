package com.spring.datajpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	String message;

	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(String message) {
		super(message);
		this.message = message;
	}
}