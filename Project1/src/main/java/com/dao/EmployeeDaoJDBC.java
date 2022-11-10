package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.exceptions.EmployeeAlreadyExistsException;
import com.models.Employee;
import com.models.Role;
import com.utils.JDBCConnectionUtil;

public class EmployeeDaoJDBC implements EmployeeDao {

	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();
	
	
	@Override
	public void createEmployee(Employee e) {
		
		int role = 2;
//		int role = e.getRole().ordinal() + 1;
//		if(role == 1) {
//			e.setRole(Role.MANAGER);
//		} else {
//			e.setRole(Role.EMPLOYEE);
//		}
		
		String sql = "INSERT INTO employee (firstName, lastName, email, password, role) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = conUtil.getConnection()){
			PreparedStatement prepstat = connection.prepareStatement(sql);
			prepstat.setString(1, e.getFirstName());
			prepstat.setString(2, e.getLastName());
			prepstat.setString(3, e.getEmail());
			prepstat.setString(4, e.getPassword());
			prepstat.setInt(5, role);
			prepstat.execute();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	

	
	@Override
	public List<Employee> readAllEmployees() {
		List<Employee> eList = new ArrayList<>();
		String sql = "SELECT * FROM employee ORDER BY id";
		try(Connection connection = conUtil.getConnection()) {
			PreparedStatement prepstat = connection.prepareStatement(sql);
			ResultSet result = prepstat.executeQuery();
			while(result.next()) {
				Employee e = new Employee();
				e.setId(result.getInt(1));
				
				if(result.getInt(6) == 1) {
					e.setRole(Role.MANAGER);
				} else {
					e.setRole(Role.EMPLOYEE);
				}
				
				e.setFirstName(result.getString(2));
				e.setLastName(result.getString(3));
				e.setEmail(result.getString(4));
				e.setPassword(result.getString(5));
				
				eList.add(e);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return eList;
	}

	
	@Override
	public Employee getEmployeeByEmail(String email) {
		
		Employee e = null;
		
		try {
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employee WHERE email='" + email + "'";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				e = new Employee();
				e.setId(result.getInt(1));
				
				if(result.getInt(6) == 1) {
					e.setRole(Role.MANAGER);
				} else {
					e.setRole(Role.EMPLOYEE);
				}
				
				e.setFirstName(result.getString(2));
				e.setLastName(result.getString(3));
				e.setEmail(result.getString(4));
				e.setPassword(result.getString(5));
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return e;
	}

	
	@Override
	public void updateEmployee(Employee e) {
		
		try {
			Connection connection = conUtil.getConnection();
			
			int role = e.getRole().ordinal() + 1;
			if(role == 1) {
				e.setRole(Role.MANAGER);
			} else {
				e.setRole(Role.EMPLOYEE);
			}
			
			String sql = "UPDATE employee SET firstName ='" + e.getFirstName() + "', lastName ='" + e.getLastName() + "', email ='" 
					+ e.getEmail() + "', password ='" + e.getPassword() + "', role =" + role + " WHERE id =" + e.getId();
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	public Employee getEmployeeById(int id) {
		
		Employee e = new Employee();
		
		try {
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM employee WHERE id=?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setInt(1, id);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				e = new Employee();
				e.setId(result.getInt(1));
				
				if(result.getInt(6) == 1) {
					e.setRole(Role.MANAGER);
				} else {
					e.setRole(Role.EMPLOYEE);
				}
				
				e.setFirstName(result.getString(2));
				e.setLastName(result.getString(3));
				e.setEmail(result.getString(4));
				e.setPassword(result.getString(5));
			}
			
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return e;
	}


	

}
