package com.yash.dao;

import java.util.List;

import com.yash.pojo.Task;

public interface TodoDAO {
	Task getTaskById(int id);
	List<Task> getAllTasks();
	void saveTask(Task task);
	void deleteTask(int id); 
}
