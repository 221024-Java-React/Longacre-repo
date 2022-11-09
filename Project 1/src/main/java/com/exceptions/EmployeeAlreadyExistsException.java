package com.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeAlreadyExistsException() {
		super("This employee already exists!");
	}
	
	
}
