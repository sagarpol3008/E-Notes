package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

public class UserDAO {
	private Connection connection;

	public UserDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addUser(UserDetails userdetails) throws ClassNotFoundException {
		
		boolean f = false;
		
		try {
			String query  = "insert into user(name,email,password) values(?,?,?)";
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userdetails.getName());
			preparedStatement.setString(2, userdetails.getEmail());
			preparedStatement.setString(3, userdetails.getPassword());
			System.out.println(preparedStatement);
			int i = preparedStatement.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	
	public UserDetails loginUser(UserDetails userdetails) {
		UserDetails user = null;
		
		
		try {
			
			String query = "select * from user where email=? and password=?";
			
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, userdetails.getEmail());
			preparedstatement.setString(2, userdetails.getPassword());
			
			ResultSet resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
				
				user = new UserDetails();
				user.setId(resultset.getInt("id"));
				user.setName(resultset.getString("name"));
				user.setEmail(resultset.getString("email"));
				user.setPassword(resultset.getString("password"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return user;
	}
	

}
