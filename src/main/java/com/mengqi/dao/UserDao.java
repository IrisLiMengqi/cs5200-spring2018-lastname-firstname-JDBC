package com.mengqi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mengqi.models.User;

public class UserDao {

	private static final String URL = "jdbc:mysql://cs5200-spring2018-li.c4hg65tbdcwa.us-east-2.rds.amazonaws.com/hw2_Mengqi_Li_spring_2018";
	private static final String USERNAME = "Mengqi";
	private static final String PASSWORD = "XX8585xx!";
	
	public static UserDao instance = null;
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	private UserDao(){}

	public int createUser(User user) {

		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "INSERT INTO user (personId, userAgreement) VALUES (?,?);";
			
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, user.getId());
			statement.setBoolean(2, user.isUserAgreement());
			results = statement.executeUpdate();
			
			String sql2 = "INSERT INTO person (id, firstName, lastName, username, password, email) VALUES (?, ?, ?, ?, ?, ?);";
			statement = connection.prepareStatement(sql2);
			statement.setInt(1, user.getId());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getUsername());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmail());
			
			results = statement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return results;
	}
	

}
