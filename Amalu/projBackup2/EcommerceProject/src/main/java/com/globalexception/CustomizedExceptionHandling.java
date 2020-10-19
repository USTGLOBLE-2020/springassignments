package com.globalexception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomizedExceptionHandling {
	@ExceptionHandler(MessageNotFoundException.class)
	public ResponseEntity<Object> handleExceptions( MessageNotFoundException exception) {
	ExceptionResponse response = new ExceptionResponse();
	response.setDateTime(LocalDateTime.now());
	response.setMessage(exception.getMessage());
	ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	return entity;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleExceptions( ResourceNotFoundException exception) {
	ExceptionResponse response = new ExceptionResponse();
	response.setDateTime(LocalDateTime.now());
	response.setMessage(exception.getMessage());
	ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	return entity;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleExceptions( IllegalArgumentException exception) {
	ExceptionResponse response = new ExceptionResponse();
	response.setDateTime(LocalDateTime.now());
	response.setMessage("id given is invalid");
	ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	return entity;
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleExceptions( MethodArgumentNotValidException exception) {
	ExceptionResponse response = new ExceptionResponse();
	response.setDateTime(LocalDateTime.now());
	response.setMessage("validation error");
	ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	return entity;
	}
}
