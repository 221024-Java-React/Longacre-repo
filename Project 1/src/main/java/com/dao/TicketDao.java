package com.dao;

import java.util.List;

import com.models.Ticket;

public interface TicketDao {

	//Interface Methods
	public void createTicket(Ticket t) throws Exception;
	public List<Ticket> readAllTickets();
	public List<Ticket> readPendingTickets();
	public List<Ticket> readEmployeeTickets(int empId);
	public void updateTicket(Ticket t);
	
	
}
