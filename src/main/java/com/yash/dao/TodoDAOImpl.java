package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.pojo.Task;
import com.yash.utils.DBConnection;
import com.yash.utils.NextInt;

public class TodoDAOImpl implements TodoDAO{
	private List<Task> tasks = new ArrayList();
	
	private Connection connection;
	
	public void addTask(String name, String description) {
		System.out.println("Inside addTask: DaoImpl");
		try {
			connection = DBConnection.getConnection();
			
			int id = NextInt.getNextInt(); 
			System.out.println("id: " + id);
			
			String q = "insert into Tasks (id, name, description, status) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(q);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, description);
			ps.setString(4, "pending");
			
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
