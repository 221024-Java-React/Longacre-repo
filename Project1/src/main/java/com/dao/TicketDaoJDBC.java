package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.models.Ticket;
import com.models.TicketStatus;
import com.utils.JDBCConnectionUtil;

public class TicketDaoJDBC implements TicketDao {

	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();
	
	
	@Override
	public void createTicket(Ticket t) throws SQLException {
		
		Connection connection = conUtil.getConnection();
		
		int status = 1;
//		if(t.getStatus() != null) {
//			status = t.getStatus().ordinal() + 1;
//		}
		
		String sql = "INSERT INTO tickets (empId, amount, description, status) VALUES"
				+ "('" + t.getEmpId() + "','" + t.getAmount() + "','" + t.getDescription() + "'," + status + ")";
		Statement statement = connection.createStatement();
		statement.execute(sql);
	}
	
	

	@Override
	public List<Ticket> readAllTickets() {
		
		List<Ticket> tList = new ArrayList<>();
		
		try {
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM tickets";
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				Ticket t = new Ticket();
				t.setId(result.getInt(1));
				
				if(result.getInt(6) == 1) {
					t.setStatus(TicketStatus.PENDING);
				} else if(result.getInt(6) == 2) {
					t.setStatus(TicketStatus.APPROVED);
				} else {
					t.setStatus(TicketStatus.DENIED);
				}
				
				t.setEmpId(result.getInt(2));
				t.setAdminId(result.getString(3));
				t.setAmount(result.getDouble(4));
				t.setDescription(result.getString(5));
				
				tList.add(t);
			}		
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return tList;
	}

	
	@Override
	public List<Ticket> readEmployeeTickets(int empId) {
		
		List<Ticket> tList = new ArrayList<>();
		
		try {
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM tickets WHERE empId ='" + empId + "'";
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				Ticket t = new Ticket();
				t.setId(result.getInt(1));
				
				if(result.getInt(6) == 1) {
					t.setStatus(TicketStatus.PENDING);
				} else if(result.getInt(6) == 2) {
					t.setStatus(TicketStatus.APPROVED);
				} else {
					t.setStatus(TicketStatus.DENIED);
				}
				
				t.setEmpId(result.getInt(2));
				t.setAdminId(result.getString(3));
				t.setAmount(result.getDouble(4));
				t.setDescription(result.getString(5));
				
				tList.add(t);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return tList;
	}

	

	@Override
	public void updateTicket(Ticket t) {
		
		try {
			Connection connection = conUtil.getConnection();
			
			int status = t.getStatus().ordinal() + 1;
			if(status == 1) {
				t.setStatus(TicketStatus.PENDING);
			} else if(status == 2) {
				t.setStatus(TicketStatus.APPROVED);
			} else {
				t.setStatus(TicketStatus.DENIED);
			} 
			
			String sql = "UPDATE tickets SET adminId ='" + t.getAdminId() 
					+ "', status =" + status + " WHERE id =" + t.getId();
			Statement statement = connection.createStatement();
			statement.execute(sql);
			
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}



	@Override
	public List<Ticket> readPendingTickets() {
		List<Ticket> tList = new ArrayList<>();
		
		try {
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM tickets WHERE status = 1";
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				Ticket t = new Ticket();
				t.setId(result.getInt(1));
				t.setEmpId(result.getInt(2));
				t.setAdminId(result.getString(3));
				t.setAmount(result.getDouble(4));
				t.setDescription(result.getString(5));
				t.setStatus(TicketStatus.PENDING);
				
				tList.add(t);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return tList;
	}



	@Override
	public Ticket getTicketById(int id) {
		Ticket t = null;
		
		try {
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM tickets WHERE id ='" + id + "'";
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				t = new Ticket();
				t.setId(result.getInt(1));
				
				if(result.getInt(6) == 1) {
					t.setStatus(TicketStatus.PENDING);
				} else if(result.getInt(6) == 2) {
					t.setStatus(TicketStatus.APPROVED);
				} else {
					t.setStatus(TicketStatus.DENIED);
				}
				
				t.setEmpId(result.getInt(2));
				t.setAdminId(result.getString(3));
				t.setAmount(result.getDouble(4));
				t.setDescription(result.getString(5));
				
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return t;
	}
	
	

}
