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
	
	public void addTask(String name, String description) {
		try {
			Connection con = DBConnection.getConnection();
			
			String q = "insert into Tasks values(?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.executeUpdate();
			
			System.out.println("data inserted successfully via dao");
            con.close();
            
		} catch (SQLException e) {
			System.out.println(e);
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
