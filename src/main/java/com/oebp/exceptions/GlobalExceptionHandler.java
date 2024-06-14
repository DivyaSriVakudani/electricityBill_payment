package com.oebp.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
   
	
	@ExceptionHandler(ConsumerNumberNotFoundException.class)
	public ResponseEntity<String> exceptionHandler1(ConsumerNumberNotFoundException v)
	{
		String s =v.getMessage();
		ResponseEntity<String> re= new ResponseEntity<String>(s,HttpStatus.NOT_FOUND);
		return re;
	}
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)

	public Map<String, String> handleValidationExceptions(

	MethodArgumentNotValidException ex) {

	Map<String, String> errors = new HashMap<>();

	ex.getBindingResult().getAllErrors().forEach((error) -> {

	String fieldName = ((FieldError) error).getField();

	String errorMessage = error.getDefaultMessage();

	errors.put(fieldName, errorMessage);

	});

	return errors;
}
}
