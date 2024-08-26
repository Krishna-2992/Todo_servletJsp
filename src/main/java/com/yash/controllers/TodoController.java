package com.yash.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.yash.pojo.Task;
import com.yash.services.TodoServices;
import com.yash.services.TodoServicesImpl;
import com.yash.utils.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TodoController")
public class TodoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private TodoServices todoServices;
	
	public void init() {
		this.todoServices = new TodoServicesImpl();	
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		System.out.println("name: " + name);
		System.out.println("description: " + description);
		
		try {
			todoServices.addTask(name, description);
			System.out.println("done");
		} catch(Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add tasks");
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		List<Task> tasks = todoServices.getAllTasks(); 
		
		request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("displayTasks.jsp").forward(request, response);
	}
	
	
	
	
	
	
	
}
