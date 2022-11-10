package com.exceptions;

public class EmployeeDoesNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeDoesNotExistException() {
		super("The employee you are searching for does not exist.");
	}
	
}
