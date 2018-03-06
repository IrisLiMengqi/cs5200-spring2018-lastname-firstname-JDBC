package com.mengqi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mengqi.models.Page;
import com.mengqi.models.Widget;

public class WidgetDao {

	private static final String URL = "jdbc:mysql://cs5200-spring2018-li.c4hg65tbdcwa.us-east-2.rds.amazonaws.com/hw2_Mengqi_Li_spring_2018";
	private static final String USERNAME = "Mengqi";
	private static final String PASSWORD = "XX8585xx!";
	
	public static WidgetDao instance = null;
	public static WidgetDao getInstance() {
		if (instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	
	private WidgetDao(){}
	
	public int createWidgetForPage(int pageId, Widget widget) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "INSERT INTO widget (id, name, text, order, width, height, pageId) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, widget.getId());
			statement.setString(2, widget.getName());
			statement.setString(3, widget.getText());
			statement.setInt(4, widget.getOrder());
			statement.setInt(5, widget.getWidth());
			statement.setInt(6, widget.getHeight());
			statement.setInt(7, pageId);

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

	public Collection<Widget> findAllWidgets() {
		List <Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "SELECT * FROM widget;";
			statement = connection.prepareStatement(sql1);
			results = statement.executeQuery();
			while(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String text = results.getString("text");
				int order = results.getInt("order");
				int width = results.getInt("width");
				int height = results.getInt("height");
				Widget widget = new Widget(name, text, order, width, height);
				widgets.add(widget);
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
		return widgets;
	}

	public Collection<Widget> findWidgetsForPage(int pageId) {
		List <Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql1 = "SELECT * FROM widget WHERE pageId = ?;";
			statement = connection.prepareStatement(sql1);
			statement.setInt(1, pageId);
			results = statement.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String text = results.getString("text");
				int order = results.getInt("order");
				int width = results.getInt("width");
				int height = results.getInt("height");
				Widget widget = new Widget( name, text, order, width, height);
				widgets.add(widget);
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
		return widgets;
	}
	
	public Widget findWidgetById(int widgetId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "SELECT * FROM widget WHERE id=?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, widgetId);
			results = statement.executeQuery(sql);
			if(results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String text = results.getString("text");
				int order = results.getInt("order");
				int width = results.getInt("width");
				int height = results.getInt("height");
				Widget widget = new Widget( name, text, order, width, height);
				return widget;
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

	public int updateWidget(int widgetId, Widget widget) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "UPDATE widget"+
						"SET name=?, text=?, order=?, width=?, height"+
						"WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, widget.getName());
			statement.setString(3, widget.getText());
			statement.setInt(4, widget.getOrder());
			statement.setInt(5, widget.getWidth());
			statement.setInt(6, widget.getHeight());
			statement.setInt(7, widgetId);
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

	public int deleteWidget(int widgetId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("URL","USERNAME","PASSWORD");
			String sql = "DELETE FROM widget"+
						"WHERE id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1,widgetId);
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

