package com.yash.dao;

import java.util.List;

import com.yash.pojo.Task;

public interface TodoDAO {
	Task getTaskById(int id);
	List<Task> getAllTasks();
	void saveTask(int id, String name, String description, String status);
	void deleteTask(int id); 
}
