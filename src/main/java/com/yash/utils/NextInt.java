package com.yash.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.pojo.Task;

public class NextInt {
	public static int idCount = 0; 
	
	public static int getNextInt() throws SQLException {
		Connection connection = DBConnection.getConnection();	
		String q = "SELECT COUNT(*) FROM Tasks";
		PreparedStatement ps = connection.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		
	    if (rs.next()) {
	        int count = rs.getInt(1); // Get the value from the first column (COUNT(*))
	        
	        System.out.println("Row count: " + count);
	        return count+1;
	    } else {
	        throw new SQLException("No rows returned");
	    }
	}
}
