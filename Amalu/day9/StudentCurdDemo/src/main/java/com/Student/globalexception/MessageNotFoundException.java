package com.Student.globalexception;

public class MessageNotFoundException extends RuntimeException {

	public MessageNotFoundException(String message) {
		super(message);
	}

}
