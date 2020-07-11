package com.feg.betting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(IncorrectInputException.class)
	public ResponseEntity<String> handleException(IncorrectInputException ex, WebRequest request){
		ex.printStackTrace();
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<String> handleException(DataNotFoundException ex, WebRequest request){
		ex.printStackTrace();
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex, WebRequest request){
		ex.printStackTrace();
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
