package com.cognixia.jump.project3spring.exception;

public class DuplicateResourceException extends Exception{

	private static final long serialVersionUID = 1L;

	public DuplicateResourceException(String message) {
		super(message);
	}
	
	public DuplicateResourceException(String expectedResourceType, Object searchValue) {
		super(expectedResourceType + " containing value " + searchValue + " already exists in the database");
	}
}
