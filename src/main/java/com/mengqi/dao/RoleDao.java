package com.mengqi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDao {

	public static RoleDao instance = null;
	public static RoleDao getInstance() {
		if (instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	
	private RoleDao(){}

	public int assignWebsiteRole (int developerId, int websiteId, int roleId){
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "INSERT INTO websiteRole (developerId, websiteId, roleId) VALUES (?, ?, ?)";
			
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, developerId);
			statement.setInt(2, websiteId);
			statement.setInt(3, roleId);
			result = statement.executeUpdate();
			
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
		return result;
	}

	public int assignPageRole (int developerId, int pageId, int roleId){
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "INSERT INTO pageRole (developerId, pageId, roleId) VALUES (?, ?, ?)";
			
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
			statement.setInt(3, roleId);
			result = statement.executeUpdate();
			
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
		return result;
	}

	public int deleteWebsiteRole(int developerId, int websiteId, int roleId){
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "DELETE FROM websiteRole"+
						"WHERE developerId = ? and websiteId = ? and roleId = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			statement.setInt(3,roleId);
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

	public int deletePageRole(int developerId, int pageId, int roleId){
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "DELETE FROM pageRole"+
						"WHERE developerId = ? and pageId = ? and roleId = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,pageId);
			statement.setInt(3,roleId);
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



