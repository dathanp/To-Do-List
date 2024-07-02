package com.todolist;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	private List<Task> tasks = new ArrayList<>();
	
	public void addTask(String description) {
		Task task = new Task(description);
		tasks.add(task);
		System.out.println("Task added: " + task);
	}
	
	public void viewTasks() {
		if(tasks.isEmpty()) {
			System.out.println("No tasks");
		} else {
			for(Task task : tasks) {
				System.out.println(task);
			}
		}
	}
	
	public void editTask(int id, String newDescription) {
		for(Task task : tasks) {
			if(task.getId() == id) {
				task.setDescription(newDescription);
				System.out.println("Task updated: " + task);
				return;
			}
		}
		System.out.println("No task found");
	}
	
	public void deleteTask(int id) {
		for(Task task : tasks) {
			if(task.getId() == id) {
				tasks.remove(task);
				System.out.println("Task deleted: " + task);
				return;
			}
		}
		System.out.println("No task found");
	}
	
	public void markTaskDone(int id) {
		for(Task task : tasks) {
			if(task.getId() == id) {
				task.setDone(true);
				System.out.println("Task is now done: " + task);
				return;
			}
		}
		System.out.println("No task found");
	}
}
