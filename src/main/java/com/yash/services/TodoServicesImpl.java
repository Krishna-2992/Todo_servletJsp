package com.yash.services;

import java.util.List;

import com.yash.dao.TodoDAO;
import com.yash.dao.TodoDAOImpl;
import com.yash.pojo.Task;

public class TodoServicesImpl implements TodoServices {
	
	private TodoDAO todoDAO;

    public TodoServicesImpl() {
        this.todoDAO = new TodoDAOImpl();
    }
	
	public void addTask(String name, String description) {
		todoDAO.addTask(name, description);
	}
	
	public List<Task> getAllTasks() {
		return todoDAO.getAllTasks();
	}
	
}

