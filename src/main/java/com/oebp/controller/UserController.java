package com.oebp.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oebp.entities.User;
import com.oebp.exceptions.DuplicateUserException;
import com.oebp.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody @Valid User user) throws DuplicateUserException {
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.ACCEPTED);
	}

	@PostMapping("/login")
	public ResponseEntity<HashMap<String, String>> loginUser(@RequestBody @Valid User user) {
		User user1 = userService.loginUser(user);
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "login successful");
		response.put("username", user.getUserName());
		response.put("uid", String.valueOf(user1.getUserId()));
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@PutMapping("/forgotpassword")
	public ResponseEntity<User> forgetPassword(@RequestParam String username) {
		System.out.println(username);
		return ResponseEntity.status(HttpStatus.OK).body(userService.forgetPassword(username));
	}

	@PutMapping("/changepassword")
	public ResponseEntity<User> changePassword(@RequestParam String username) {
		System.out.println(username);
		return ResponseEntity.status(HttpStatus.OK).body(userService.changePassword(null,username));
	}
	@PutMapping("/emailpassword")
	public ResponseEntity<User> emailPassword(@RequestParam String username) {
		System.out.println(username);
		return ResponseEntity.status(HttpStatus.OK).body(userService.emailPassword(username));
	}
	@GetMapping("/userid/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable @Valid int uid) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(uid));
	}

	@GetMapping("/username/{uname}")
	public ResponseEntity<User> getByUserName(@PathVariable @Valid String uname) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUserName(uname));
	}

	@GetMapping("/allusers")
	public List<User> getallUsers() {
		return userService.getallUsers();
	}

}
