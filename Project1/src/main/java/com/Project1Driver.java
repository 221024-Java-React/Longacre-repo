package com;

import com.controllers.EmployeeController;
import com.controllers.TicketController;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoJDBC;
import com.dao.TicketDao;
import com.dao.TicketDaoJDBC;
import com.exceptions.EmployeeAlreadyExistsException;
import com.exceptions.EmployeeDoesNotExistException;
import com.exceptions.IncorrectPasswordException;
import com.services.EmployeeService;
import com.services.TicketService;

import io.javalin.Javalin;

public class Project1Driver {

	public static void main(String[] args) {

		
		EmployeeDao eDao = new EmployeeDaoJDBC();
		EmployeeService eServ = new EmployeeService(eDao);
		EmployeeController eController = new EmployeeController(eServ);
		
		
		TicketDao tDao = new TicketDaoJDBC();
		TicketService tServ = new TicketService(tDao);
		TicketController tController = new TicketController(tServ);
		
		//Set up javalin app and routes
		Javalin app = Javalin.create(config -> {
		    config.plugins.enableCors(cors -> {
		        cors.add(it -> {
		            it.anyHost();
		        });
		    });
		});
		
		//Routes/Handlers
		app.get("/hello", (ctx) -> ctx.result("Hello, we are making our first get request"));
		
		//EMPLOYEE HANDLERS
		app.post("/employee/register/", eController.handleRegister);
		app.post("/employee/login/", eController.handleLogin);
		app.get("/employee/all/", eController.handleGetAll);
		app.put("/employee/update/", eController.handleUpdate);
		
		
		//TICKET HANDLERS
		app.post("/ticket/create/", tController.handleNewTicket);
		app.get("/ticket/all/", tController.handleGetAllTickets);
		app.get("/ticket/allPendingTickets/", tController.handleReadAllPendingTickets);
		app.post("/ticket/getEmployeeTickets/", tController.handleGetEmployeeTickets);
		app.put("/ticket/update/", tController.handleUpdateTicketStatus);
		
		
		//EXCEPTIONS
		app.exception(EmployeeDoesNotExistException.class, (e, context) -> {
			context.status(404);
			context.result("You were unable to login");
		});
		
		
		app.exception(EmployeeAlreadyExistsException.class, (e, context)-> {
			context.status(409);
			context.result("You are not able to register an account with an email which already exists");
			
		});
		
		
		
		//Start the application
		app.start(8000);
		
		
	}

}
