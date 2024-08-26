package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.pojo.Task;
import com.yash.utils.DBConnection;

public class TodoDAOImpl implements TodoDAO{
	private List<Task> tasks = new ArrayList();
	
	private Connection connection;
	
	public void addTask(String name, String description) {
		try {
			connection = DBConnection.getConnection();
			
			String q = "insert into Tasks values(?,?)";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setString(1, name);
			ps.setString(2, description);
			int rowsAffected = ps.executeUpdate();
			
			if (rowsAffected > 0) {
                System.out.println("Task added successfully(optimized)");
            } else {
                System.out.println("Failed to add task");
            }
            DBConnection.closeConnection(connection);
            
		} catch (SQLException e) {
			System.err.println("SQL Exception occurred: " + e.getMessage());
		}
	}
	
	public void saveTask(Task task) {
		tasks.add(task);
	}
	public List<Task> getAllTasks() {
		return tasks;
	}
	public Task getTaskById(int id) {
		for(Task task : tasks) {
			if(task.id == id) {
				return task;
			}
		}
		return new Task();
	}
	public void deleteTask(int id) {
		for(Task task : tasks) {
			if(task.id == id) {
				tasks.remove(task);
				break;
			}
		}
	}
}
