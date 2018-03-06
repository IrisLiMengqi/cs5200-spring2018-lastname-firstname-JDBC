package com.mengqi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mengqi.models.Page;
import com.mengqi.models.Website;

public class PageDao {
	private static final String URL = "jdbc:mysql://cs5200-spring2018-li.c4hg65tbdcwa.us-east-2.rds.amazonaws.com/hw2_Mengqi_Li_spring_2018";
	private static final String USERNAME = "Mengqi";
	private static final String PASSWORD = "XX8585xx!";
	
	public static PageDao instance = null;
	public static PageDao getInstance() {
		if (instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	
	private PageDao(){}
	
	public int createPageForWebsite(int websiteId, Page page) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "INSERT INTO page (id, title, description, views, websiteId) VALUES (?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, page.getId());
			statement.setString(2, page.getTitle());
			statement.setString(3, page.getDescription());
			statement.setInt(4, page.getViews());
			statement.setInt(5, websiteId);
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

	public Collection<Page> findAllPages() {
		List <Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "SELECT * FROM page;";
			statement = connection.prepareStatement(sql1);
			results = statement.executeQuery();
			while(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				int views = results.getInt("views");
				Page page = new Page(id, title, description, views);
				pages.add(page);
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
		return pages;
	}

	public Collection<Page> findPageForWebsite(int websiteId) {
		List <Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "SELECT * FROM website WHERE websiteId = ?;";
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, websiteId);
			results = statement.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				int views = results.getInt("views");
				Page page = new Page(id, title, description, views);
				pages.add(page);
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
		return pages;
	}
	
	public Page findPageById(int pageId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "SELECT * FROM page WHERE id=?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			results = statement.executeQuery(sql);
			if(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				int views = results.getInt("views");
				Page page = new Page(id, title, description, views);
				return page;
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

	public int updatePage(int pageId, Page page) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "UPDATE page"+
						"SET title=?, description=?, views=?"+
						"WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setInt(3, page.getViews());
			statement.setInt(4, pageId);
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

	public int deletePage(int pageId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "DELETE FROM page"+
						"WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,pageId);
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