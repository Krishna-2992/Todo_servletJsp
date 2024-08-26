package com.yash.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
	
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Driver not found.");
            ex.printStackTrace();
            return null;
        }
 
        String url = "jdbc:mysql://localhost:3306/TodoList";
        String username = "root";
        String password = "root";
 
        return DriverManager.getConnection(url, username, password);
    }
    
    public static void closeConnection(Connection connection) throws SQLException {
    	if(connection != null && !connection.isClosed()) {
    		try {
    			connection.close();
    		} catch (SQLException e) {
    			System.out.println("Error closing connection: " + e.getMessage());
    		}
    	}
    }

}