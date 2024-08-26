package com.yash.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		System.out.println("name: " + name);
		System.out.println("description: " + description);
		
		TodoServicesImpl services = new TodoServicesImpl();
		services.addTask(name, description);
		
		System.out.println("done");
	}
	
}
