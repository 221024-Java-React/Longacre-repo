package com.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Ticket;
import com.services.TicketService;

import io.javalin.http.Handler;

public class TicketController {

	private TicketService tServ;
	private ObjectMapper objectMapper;
	
	public TicketController(TicketService tServ) {
		this.tServ = tServ;
		objectMapper = new ObjectMapper();
	}
	
	
	//CONTROLLER HANDLERS
	//Create New Ticket
	public Handler handleNewTicket = (context) -> {
		Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		
		if(t.getAmount() == 0.0 || t.getDescription() == null) {
			context.status(400);
			context.result("Amount or Description missing. Ticket not created.");
		} else {
			tServ.createTicket(t);
			context.status(201);
			context.result("Ticket created!");
		}
	};
	
	
	//Get All Tickets
	public Handler handleGetAllTickets = (context) -> {
		List<Ticket> tList = tServ.getAllTickets();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
	};
	
	
	//Get All Pending Tickets
		public Handler handleReadAllPendingTickets = (context) -> {
			List<Ticket> tList = tServ.readPendingTickets();
			context.status(200);
			context.result(objectMapper.writeValueAsString(tList));
		};

	
	//Get Employee Tickets
	public Handler handleGetEmployeeTickets = (context) -> {
		Map<String, Integer> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		List<Ticket> tList =  tServ.getEmpTickets(body.get("empId"));
		context.status(200);
		context.result(objectMapper.writeValueAsString(tList));
	};
	
	
	//Update Ticket Status
	public Handler handleUpdateTicketStatus = (context) -> {
		Ticket t = objectMapper.readValue(context.body(), Ticket.class);
		
		tServ.updateTicket(t);
		context.status(200);
		context.result("Ticket status was updated");
	};
	
}
