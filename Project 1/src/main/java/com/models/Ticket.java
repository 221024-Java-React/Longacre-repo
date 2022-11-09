package com.models;

public class Ticket {

	//Variables
	private int id;
	private int empId;
	private String adminId;
	private double amount;
	private String description;
	private TicketStatus status;
	
	//Constructors
	public Ticket() {
		
	}


	public Ticket(int empId, double amount, String description) {
		super();
		this.empId = empId;
		this.amount = amount;
		this.description = description;
	}


	public Ticket(int id, String adminId, TicketStatus status) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.status = status;
	}


	//Full args Constructor
	public Ticket(int id, int empId, String adminId, double amount, String description, TicketStatus status) {
		super();
		this.id = id;
		this.empId = empId;
		this.adminId = adminId;
		this.amount = amount;
		this.description = description;
		this.status = status;
	}

	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	
}
