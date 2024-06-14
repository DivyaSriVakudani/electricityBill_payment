package com.oebp.exceptions;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oebp.entities.User;

@ControllerAdvice
public class UserControllerExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = DuplicateUserException.class)
	public ResponseEntity<HashMap<String,String>> userExists(DuplicateUserException duplicateUserException) {
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "UserName Already Exists .. Choose Different UserName");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}

	@ExceptionHandler(value = InvalidLoginCredentialException.class)
	public ResponseEntity<HashMap<String, String>> userLoginException(InvalidLoginCredentialException e) {
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "Invalid Credentials");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(value = InvalidUserIdException.class)
	public ResponseEntity<HashMap<String,String>> invalidUid(InvalidUserIdException e) {
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "Invalid User ID");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(value = InvalidUserNameException.class)
	public ResponseEntity<HashMap<String,String>> invalidUid(InvalidUserNameException e) {
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "Invalid User Name");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(value = AmountExceededException.class)
	public ResponseEntity<HashMap<String, String>> invalidamount(AmountExceededException e)
	{
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "Please pay Bill amount");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
}