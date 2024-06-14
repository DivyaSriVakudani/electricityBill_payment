package com.oebp.exceptions;

	 

	import java.util.HashMap;

	 

	import java.util.Map;

	 

	 

	import org.springframework.validation.FieldError;

	 

	import org.springframework.web.bind.MethodArgumentNotValidException;

	 

	import org.springframework.web.bind.annotation.ExceptionHandler;

	 

	import org.springframework.web.bind.annotation.RestControllerAdvice;

	 

	 

	 

	@RestControllerAdvice

	 

	public class GlobalExceptionHandler3 {

	 

	@ExceptionHandler(NoSuchBillException.class)

	 

	public String handleMyException1(NoSuchBillException ex)

	 

	{

	 

	return ex.getMessage();

	 

	}

	 

	@ExceptionHandler(BillNotFoundByBillDateException.class)

	 

	public String handleMyException2(BillNotFoundByBillDateException ex)

	 

	{

	 

	return ex.getMessage();

	 

	}
	@ExceptionHandler(NoSuchBillIdException.class)

	 

	public String handleMyException3(NoSuchBillIdException ex)

	 

	{

	 

	return ex.getMessage();

	 

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
