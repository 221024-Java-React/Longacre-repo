package com.services;

import java.sql.SQLException;
import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoJDBC;
import com.exceptions.EmployeeAlreadyExistsException;
import com.exceptions.EmployeeDoesNotExistException;
import com.exceptions.IncorrectPasswordException;
import com.models.Employee;
import com.utils.LoggingUtil;

public class EmployeeService {

	
	private EmployeeDao employeeDao;
	
	
	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	//SERVICES METHODS
	//Register Employee Method
	public void registerEmployee(Employee e) throws Exception {
		
		if(employeeDao.getEmployeeByEmail(e.getEmail()) != null) {
			LoggingUtil.getLogger().warn("Employee with email " + e.getEmail() + " already exists;");
			throw new EmployeeAlreadyExistsException();
		} else {
			employeeDao.createEmployee(e);
			LoggingUtil.getLogger().warn("Employee: " + e + " was registered");
			
		} 
	}
	
	
	//Login Method
		public Employee login(String email, String password) throws Exception {
			Employee e = employeeDao.getEmployeeByEmail(email);
			
			if(e == null) {
				LoggingUtil.getLogger().warn("Employee with email " + email + " had a failed login attempt");
				
				throw new EmployeeDoesNotExistException();
			} else if(password.equals(e.getPassword())) {
				LoggingUtil.getLogger().info("Employee " + email + " logged in");
				return e;
			} else {
				LoggingUtil.getLogger().warn("You entered the incorrect password for email " + email);
			}
			
			return e;
		}
		
		
	//Get All Registered Employees	
		public List<Employee> getAllRegistered() {
			return employeeDao.readAllEmployees();
		}

		
	//Update Employee
		public void updateEmployee(Employee e) {
			employeeDao.updateEmployee(e);
			LoggingUtil.getLogger().info("Employee " + e.getEmail() + " was successfully updated in the system");
		}
		

}
