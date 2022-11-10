package com.dao;

import java.util.List;

import com.models.Employee;

public interface EmployeeDao {

	
	//Interface Methods
	public void createEmployee(Employee e) throws Exception;
	public List<Employee> readAllEmployees();
	public Employee getEmployeeByEmail(String email);
	public void updateEmployee(Employee e);
	public Employee getEmployeeById(int id);
	
}
