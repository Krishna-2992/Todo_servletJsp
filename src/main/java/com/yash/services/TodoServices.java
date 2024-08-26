package com.yash.services;

import java.util.List;

import com.yash.pojo.Task;

public interface TodoServices {
	
	public void addTask(String name, String description);
	public List<Task> getAllTasks();
}
