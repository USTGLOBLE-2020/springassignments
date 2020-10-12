package com.spring.datajpa.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorResponse {
	private String errorMessage;
	private int statusCode;

	public ErrorResponse() {
	}

	public ErrorResponse(String errorMessage, int statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}