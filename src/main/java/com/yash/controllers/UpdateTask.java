package com.yash.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.pojo.Task;
import com.yash.services.TodoServices;
import com.yash.services.TodoServicesImpl;
import com.yash.utils.DBConnection;

@WebServlet("/UpdateTask")
public class UpdateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TodoServices todoServices;
	
	public void init() {
		this.todoServices = new TodoServicesImpl();	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taskId = request.getParameter("id");
		System.out.println("taskId to be updated: " + taskId);
		
		if (taskId == null || taskId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Task ID is required");
            return;
        }
		
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		
		try {
        	conn = DBConnection.getConnection();
        	String updateQuery = "Update Tasks set status='done' where id=?";
        	pstmt = conn.prepareStatement(updateQuery);
        	pstmt.setString(1, taskId);
        	
        	int rowsUpdated = pstmt.executeUpdate();
        	if(rowsUpdated == 0) {
        		throw new SQLException("No task found with ID: " + taskId);
        	}
        	
        	// set the tasks attribute!!
        	List<Task> tasks = todoServices.getAllTasks(); 
			request.setAttribute("tasks", tasks);
			request.setAttribute("message", "Task Updated successfully");
        	
            request.getRequestDispatcher("/displayTasks.jsp").forward(request, response);
            System.out.println("item updated successfully!!");
            
        } catch (SQLException e) {
            request.setAttribute("errorMessage", "Failed to update task: " + e.getMessage());
            request.getRequestDispatcher("/displayTasks.jsp").forward(request, response);
        } finally {
        	try {
        		if(rs!=null) rs.close();
        		if(pstmt != null) pstmt.close();
        		if(conn != null) conn.close();
        	} catch(SQLException ex) {
        		System.out.println("Error closing JDBC resources: " + ex.getMessage());
        	}
        }

	}	
	

}
