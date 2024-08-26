package com.yash.services;

import com.yash.dao.TodoDAOImpl;

public class TodoServicesImpl implements TodoServices {
	
	public void addTask(String name, String description) {
		System.out.println("Inside addTask: TodoServicesImpl");
		TodoDAOImpl daoImpl = new TodoDAOImpl();
		daoImpl.addTask(name, description);
	}
	
}

