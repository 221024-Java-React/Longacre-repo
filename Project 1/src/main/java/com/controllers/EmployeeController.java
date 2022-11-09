package com.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Employee;
import com.services.EmployeeService;

import io.javalin.http.Handler;

public class EmployeeController {

	
	private EmployeeService eServ;
	private ObjectMapper objectMapper;
	
	
	public EmployeeController(EmployeeService eServ) {
		this.eServ = eServ;
		objectMapper = new ObjectMapper();
	}
	
	
	//CONTROLLER HANDLERS
	//Register Handler
	public Handler handleRegister = (context) -> {
		Employee e = objectMapper.readValue(context.body(), Employee.class);
		
		eServ.registerEmployee(e);
		
		context.status(201);
		context.result(objectMapper.writeValueAsString(e));
	};
	
	
	//Get All Handler
	public Handler handleGetAll = (context) -> {
		List<Employee> eList = eServ.getAllRegistered();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(eList));
	};
	
	
	//Login Handler
	public Handler handleLogin = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		Employee loggedIn = eServ.login(body.get("email"), body.get("password"));
		
		if(loggedIn.getPassword().equals(body.get("password"))) {
			context.status(200);
			context.result(loggedIn.getEmail() + " successfully logged in");
		} else {
			context.result(loggedIn.getEmail() + " failed to log in");
		}
		
	};
	
	
	
	public Handler handleUpdate = (context) -> {
		Employee e = objectMapper.readValue(context.body(), Employee.class);
		
		eServ.updateEmployee(e);
		
		context.status(200);
		context.result("Employees information was updated");
		
	};
	
	
}
