package com.todolist;

import java.util.Scanner;

public class main {

	private static TaskManager taskManager = new TaskManager();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("To-Do-List");
			System.out.println("Pick one option");
			System.out.println("1. add task");
			System.out.println("2. view tasks");
			System.out.println("3. edit task");
			System.out.println("4. delete task");
			System.out.println("5. mark task as done");
			System.out.println("6. close program");
			
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
				case 1:
					System.out.println("Enter task ");
					String description = scanner.nextLine();
					taskManager.addTask(description);
					break;
				case 2:
					taskManager.viewTasks();
					break;
				case 3:
					System.out.println("Enter task ID to edit");
					int editId = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter new description");
					String newDescription = scanner.nextLine();
					taskManager.editTask(editId, newDescription);
					break;
				case 4:
					System.out.println("Enter task Id to delete");
					int deleteId = scanner.nextInt();
					scanner.nextLine();
					taskManager.deleteTask(deleteId);
					break;
				case 5:
					System.out.println("Enter ID to complete");
					int doneId = scanner.nextInt();
					scanner.nextLine();
					taskManager.markTaskDone(doneId);
					break;
				case 6:
					System.out.println("Closing program");
					scanner.close();
					return;
				default:
					System.out.println("Not a valid choice");
			}
		}
	}
}
