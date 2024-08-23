package com.yash.dao;

import java.util.ArrayList;
import java.util.List;

import com.yash.pojo.Task;

public class TodoDAOImpl implements TodoDAO{
	private List<Task> tasks = new ArrayList();
	
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
