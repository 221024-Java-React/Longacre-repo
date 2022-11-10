package com.exceptions;

public class TicketAlreadyProcessedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TicketAlreadyProcessedException() {
		super("This ticket has already been processed!");
	}

}
