package com.services;

import java.util.List;

import com.dao.TicketDao;
import com.exceptions.TicketAlreadyProcessedException;
import com.exceptions.TicketInfoMissingException;
import com.models.Ticket;
import com.models.TicketStatus;
import com.utils.LoggingUtil;

public class TicketService {

	private TicketDao ticketDao;
	
	public TicketService(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	
	//SERVICE METHODS	
	//Create Ticket
	public void createTicket(Ticket t) {
		
		if(t.getAmount() == 0.0 || t.getDescription() == null ) {
			throw new TicketInfoMissingException();
		}
		
		try {
			ticketDao.createTicket(t);
			LoggingUtil.getLogger().warn("Ticket: " + t + " was created");
		} catch(Exception ex) {
			LoggingUtil.getLogger().warn("Ticket " + t + " was NOT created");
			throw new TicketInfoMissingException();
		}
	}
	
	//Get All Tickets
	public List<Ticket> getAllTickets() {
		return ticketDao.readAllTickets();
	}
	
	
	//Get All Pending Tickets
	public List<Ticket> readPendingTickets() {
		return ticketDao.readPendingTickets();
	}
	
	
	//Get Specific Employee Ticket
	public List<Ticket> getEmpTickets(int empId) {
	
		return ticketDao.readEmployeeTickets(empId);
		
	}
	
	public Ticket getTicketById(int id) {
		return ticketDao.getTicketById(id);
	}
	
	
	//Update Ticket
	public void updateTicket(Ticket t) {
		
		Ticket ticket = ticketDao.getTicketById(t.getId());
		
		if(ticket.getStatus().equals(TicketStatus.PENDING)) {
			
			ticketDao.updateTicket(t);
			LoggingUtil.getLogger().info("Ticket " + t.getId() + " was successfully updated in the system");
			
		} else {
			System.out.println("This ticket has already been processed.");
			throw new TicketAlreadyProcessedException();
		}
	}
	
	
	
}
