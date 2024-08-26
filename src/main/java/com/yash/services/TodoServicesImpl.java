package com.yash.services;

import com.yash.dao.TodoDAOImpl;

public class TodoServicesImpl implements TodoServices {
	
	public void addTask(String name, String description) {
		TodoDAOImpl daoImpl = new TodoDAOImpl();
		daoImpl.addTask(name, description);
	}
	
}

