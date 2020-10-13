package com.spring.datajpa.exception;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Sridhar rayana
 *Class used for handing all global exceptions 
 */
@Controller
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseBody
	public ErrorResponse handleCustomException(RecordNotFoundException ex) {
		ErrorResponse responseError = new ErrorResponse();
		responseError.setErrorMessage(ex.getMessage());
		responseError.setStatusCode(HttpStatus.NOT_FOUND.value());
		return responseError;

	}

	@ExceptionHandler(NoDataFoundException.class)
	@ResponseBody
	public ErrorResponse handleNoDataFoundException(NoDataFoundException ex) {
		ErrorResponse responseError = new ErrorResponse();
		responseError.setErrorMessage(ex.getMessage());
		responseError.setStatusCode(HttpStatus.NOT_FOUND.value());
		return responseError;

	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorResponse handleAllException(Exception ex) {
		ErrorResponse responseError = new ErrorResponse();
		responseError.setErrorMessage(ex.getMessage());
		responseError.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return responseError;
	}

	 
	/**
	 *method used for error handling for Entity class validation
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed", ex.getBindingResult().toString());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
}