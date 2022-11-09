package com.exceptions;

public class IncorrectPasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public IncorrectPasswordException() {
		super("This password is incorrect!");
	}
	
}
