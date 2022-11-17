package com.cognixia.jump.project3spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.project3spring.exception.DuplicateResourceException;
import com.cognixia.jump.project3spring.exception.ResourceNotFoundException;
import com.cognixia.jump.project3spring.model.User;
import com.cognixia.jump.project3spring.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService service;
	
	
	@GetMapping
	public ResponseEntity<?> getUsers() {
		List<User> users = service.getUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) throws ResourceNotFoundException {
		User user = service.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		
		User created = service.createUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
		
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Map<String, Object> userDetails) throws Exception {

		User updated = service.updateUser(id, userDetails);
		
		
		if (userDetails.containsKey("username")) {
			return ResponseEntity.status(HttpStatus.OK).body("Username may have changed, must reauthenticate to access API.\n" + updated);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) throws ResourceNotFoundException {
		User targetUser = service.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(targetUser);
	}
}











