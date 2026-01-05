package com.hcl.jdbc_and_servlet_crud_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.jdbc_and_servlet_crud_project.connection.JdbcConnection;
import com.hcl.jdbc_and_servlet_crud_project.dto.User;

public class UserDao {
	/**
	 * Check if email already exists in the database
	 * @param email
	 * @return
	 */
	public boolean isEmailExist(String email) {
		
		String query = "SELECT 1 FROM userregistration WHERE email = ? LIMIT 1";
		
		try (Connection con = JdbcConnection.getJdbcConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * Register a new user in the database
	 * 
	 * @param user
	 * @return
	 */
	public boolean registerUser(User user) {
		
		//Validation for email and password
		if(user.getEmail() == null || user.getPassword() == null || user.getEmail().trim().isEmpty() || user.getPassword().trim().isEmpty()) {
			System.out.println("-----------Email or Password is null/empty! Please provide valid data.-----------");
			return false;
		}
		
		if (isEmailExist(user.getEmail())) {
			System.out.println("-----------Email already exists! Please use a different email.-----------");
			return false;
		}
		
		boolean isUserRegistered = false;
		// Database connection
		Connection con = JdbcConnection.getJdbcConnection();
		if(con == null) {
			System.out.println("-----------Please Check DB Connection! Connection is Not Stablished!!!-----------");
			return false;
		}
		
		 // To insert user data into database userresgistration table
		String insertUserQuery = "INSERT INTO userregistration (email, password) VALUES (?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(insertUserQuery);
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				isUserRegistered = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isUserRegistered;
	}
	
	
	/**
	 * Login user by validating email and password
	 * 
	 * @param user
	 * @return
	 */
	public User loginUser(String email) {
		String sql = "SELECT * FROM userregistration WHERE email = ?";
		User user = null;

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcConnection.getJdbcConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}