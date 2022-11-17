package com.cognixia.jump.project3spring.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognixia.jump.project3spring.controller.AuthenticationController;
import com.cognixia.jump.project3spring.exception.AdminOnlyException;
import com.cognixia.jump.project3spring.exception.DuplicateResourceException;
import com.cognixia.jump.project3spring.exception.ResourceNotFoundException;
import com.cognixia.jump.project3spring.model.User;
import com.cognixia.jump.project3spring.model.User.Role;
import com.cognixia.jump.project3spring.repository.UserRepository;
import com.cognixia.jump.project3spring.util.JwtUtil;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	@Autowired
	PasswordEncoder encoder;

	public List<User> getUsers() {
		return repo.findAll();
	}

	public User getUserById(Long id) throws ResourceNotFoundException {
		Optional<User> found = repo.findById(id);
		if (found.isPresent()) {
			return found.get();
		}
		throw new ResourceNotFoundException("User", id);
	}

	public User createUser(User user) {
		user.setId(null);

		// Each password for a new user gets encoded
		user.setPassword(encoder.encode(user.getPassword()));

		return repo.save(user);
	}

	public User updateUser(Long id, Map<String, Object> userDetails) throws Exception {
		Optional<User> found = repo.findById(id);
		if (found.isPresent()) {
			User user = found.get();

			// Manually check for every possible variable in json
			if (userDetails.containsKey("username")) {
				String username = (String) userDetails.get("username");
				// Check if username is already in database
				if (repo.findByUsername(username).isPresent()
						&& repo.findByUsername(username).get().getId() != user.getId()) {
					throw new DuplicateResourceException("User", username);
				}
				user.setUsername(username);
			}
			if (userDetails.containsKey("password")) {
				String password = (String) userDetails.get("password");
				String encoded = encoder.encode(password);
				user.setPassword(encoded);
			}
			if (userDetails.containsKey("email")) {
				String email = (String) userDetails.get("email");
				if (Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches()) {
					user.setEmail(email);
				} else {
					throw new Exception("Invalid email");
				}
			}
			if (userDetails.containsKey("role")) {
				// Only ADMINs can change user roles
				if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
					Role role = Role.valueOf((String) userDetails.get("role"));
					user.setRole(role);
				} else {
					throw new AdminOnlyException("Changing user roles directly");
				}
			}

			return repo.save(user);
		}
		throw new ResourceNotFoundException("User", id);
	}

	public User deleteUser(Long id) throws ResourceNotFoundException {
		Optional<User> found = repo.findById(id);
		if (found.isPresent()) {
			repo.delete(found.get());
			;
			return found.get();
		}
		throw new ResourceNotFoundException("User", id);
	}

}
