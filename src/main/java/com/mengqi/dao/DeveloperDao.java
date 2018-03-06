package com.mengqi.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.mengqi.models.Developer;

public class DeveloperDao {
	
	private static final String URL = "jdbc:mysql://cs5200-spring2018-li.c4hg65tbdcwa.us-east-2.rds.amazonaws.com/hw2_Mengqi_Li_spring_2018";
	private static final String USERNAME = "Mengqi";
	private static final String PASSWORD = "XX8585xx!";
	
	public static DeveloperDao instance = null;
	public static DeveloperDao getInstance() {
		if (instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	
	private DeveloperDao(){}
	

	public List<Developer> findAllDevelopers(){
		List <Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "SELECT * FROM developer INNER JOIN person ON person.id=developer.personId;";
			statement = connection.prepareStatement(sql1);
			results = statement.executeQuery();
			while(results.next()) {
				String firstName = results.getString("person.firstName");
				String lastName = results.getString("person.lastName");
				String userName = results.getString("person.userName");
				String password = results.getString("person.password");
				String email = results.getString("person.email");
				int developerId = results.getInt("developer.id");
				String developerKey = results.getString("developer.developerKey");
				Developer developer = new Developer(developerId,firstName, lastName, userName, password,
													email, developerKey);
				developers.add(developer);
			}
			
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
		return developers;
	}
	
	
	public int createDeveloper(Developer developer) {

		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "INSERT INTO developer (personId, developerKey) VALUES (?,?);";
			
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, developer.getId());
			statement.setString(2, developer.getDeveloperKey());
			results = statement.executeUpdate();
			
			String sql2 = "INSERT INTO person (id, firstName, lastName, username, password, email,) VALUES (?, ?, ?, ?, ?, ?);";
			statement = connection.prepareStatement(sql2);
			statement.setInt(1, developer.getId());
			statement.setString(2, developer.getFirstName());
			statement.setString(3, developer.getLastName());
			statement.setString(4, developer.getUsername());
			statement.setString(5, developer.getPassword());
			statement.setString(6, developer.getEmail());
			
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
	
	
	public Developer findDeveloperById(int developerId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "SELECT * FROM (developer INNER JOIN person ON person.id=developer.personId) WHERE developer.id=?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			results = statement.executeQuery(sql);
			if(results.next()) {
				String firstName = results.getString("person.firstName");
				String lastName = results.getString("person.lastName");
				String userName = results.getString("person.userName");
				String password = results.getString("person.password");
				String email = results.getString("person.email");
				String developerKey = results.getString("developer.developerKey");
				Developer developer = new Developer(developerId, firstName, lastName, userName, password,
													email, developerKey);
				return developer;
			}
			
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
		return null;
		
	}

	public Developer findDeveloperByUsername(String username) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "SELECT * FROM (developer INNER JOIN person ON person.id=developer.personId) WHERE person.username=?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			results = statement.executeQuery(sql);
			if(results.next()) {
				String firstName = results.getString("person.firstName");
				String lastName = results.getString("person.lastName");
				String userName = results.getString("person.userName");
				String password = results.getString("person.password");
				String email = results.getString("person.email");
				int developerId = results.getInt("developer.id");
				String developerKey = results.getString("developer.developerKey");
				Developer developer = new Developer(developerId,firstName, lastName, userName, password,
														email, developerKey);
				return developer;
			}
			
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
		return null;
		
	}

	public Developer findDeveloperByCredentials(String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "SELECT * FROM (developer INNER JOIN person ON person.id=developer.personId)" + 
							"WHERE person.username=? and person.password=?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(1, password);
			results = statement.executeQuery(sql);
			if(results.next()) {
				String firstName = results.getString("person.firstName");
				String lastName = results.getString("person.lastName");
				String email = results.getString("person.email");
				int developerId = results.getInt("developer.id");
				String developerKey = results.getString("developer.developerKey");
				Developer developer = new Developer(developerId, firstName, lastName, username, password,
														email, developerKey);
				return developer;
			}
			
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
		return null;
	}

	public int updateDeveloper(int developerId, Developer developer) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "UPDATE developer"+
						"SET firstName=?, lastName=?, userName=?, password=?, email=?, developerKey=?"+
						"WHERE developer.id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, developer.getFirstName());
			statement.setString(2, developer.getLastName());
			statement.setString(3, developer.getUsername());
			statement.setString(4, developer.getPassword());
			statement.setString(5, developer.getEmail());
			statement.setString(6, developer.getDeveloperKey());
			statement.setInt(8, developerId);
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

	public int deleteDeveloper(int developerId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "DELETE FROM developer"+ 
						"WHERE develope.id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
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
