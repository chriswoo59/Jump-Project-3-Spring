package com.cognixia.jump.project3spring.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognixia.jump.project3spring.exception.ResourceNotFoundException;
import com.cognixia.jump.project3spring.model.User;
import com.cognixia.jump.project3spring.repository.UserRepository;

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

	public User updateUser(Long id, User user) throws ResourceNotFoundException {
		Optional<User> found = repo.findById(id);
		if (found.isPresent()) {
			// Just in case id is different, we want this to update the same id
			user.setId(id);
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
