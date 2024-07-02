package com.todolist;

public class Task {
	
	private static int count = 0;
	private int id;
	private String Description;
	private boolean isDone;
	
	public Task(String description) {
		this.id = count++;
		this.Description = description;
		this.isDone = false;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		this.Description = description;
	}
	
	public boolean isDone() {
		return isDone;
	}
	
	public void setDone(boolean isDonee) {
		this.isDone = isDonee;
	}
	
	@Override
	public String toString() {
		return "Task [ID= " + id + ", description = " + Description + ", isDone = " + isDone + "]";
	}
}
