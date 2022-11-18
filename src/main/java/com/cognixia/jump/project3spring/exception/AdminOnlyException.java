package com.cognixia.jump.project3spring.exception;

public class AdminOnlyException extends Exception{

	private static final long serialVersionUID = 1L;

	public AdminOnlyException(String attemptedCommand) {
		super(attemptedCommand + " is an Admin-only command. You do not have the proper role.");
	}
}
