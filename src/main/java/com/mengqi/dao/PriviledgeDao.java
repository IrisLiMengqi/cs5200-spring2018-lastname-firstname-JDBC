package com.mengqi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PriviledgeDao {

	public static PriviledgeDao instance = null;
	public static PriviledgeDao getInstance() {
		if (instance == null) {
			instance = new PriviledgeDao();
		}
		return instance;
	}
	
	private PriviledgeDao(){}

	public int assignWebsitePriviledge (int developerId, int websiteId, int priviledgeId){
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "INSERT INTO websiteRole (developerId, websiteId, priviledgeId) VALUES (?, ?, ?)";
			
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, developerId);
			statement.setInt(2, websiteId);
			statement.setInt(3, priviledgeId);
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

	public int assignPagePriviledgeId (int developerId, int pageId, int priviledgeId){
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "INSERT INTO pageRole (developerId, pageId, priviledgeId) VALUES (?, ?, ?)";
			
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
			statement.setInt(3, priviledgeId);
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

	public int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId){
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "DELETE FROM websiteRole"+
						"WHERE developerId = ? and websiteId = ? and priviledgeId = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,developerId);
			statement.setInt(2,websiteId);
			statement.setInt(3,priviledgeId);
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

	public int deletePagePriviledge(int developerId, int pageId, int priviledgeId){
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
			statement.setInt(3,priviledgeId);
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


