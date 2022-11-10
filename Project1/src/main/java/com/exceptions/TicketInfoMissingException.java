package com.exceptions;

public class TicketInfoMissingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public TicketInfoMissingException() {
		super("Ticket amount or description is missing. Ticket not created");
	}
}
