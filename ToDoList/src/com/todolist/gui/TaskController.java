package com.todolist.gui;

import com.todolist.Task;
import com.todolist.TaskManager;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TaskController {
    @FXML
    private TextField taskInput;

    @FXML
    private ListView<String> taskList;

    private TaskManager taskManager = new TaskManager();

    @FXML
    private void handleAddTask() {
        String description = taskInput.getText();
        if (!description.isEmpty()) {
            taskManager.addTask(description);
            updateTaskList();
            taskInput.clear();
        }
    }

    private void updateTaskList() {
        taskList.getItems().clear();
        for (Task task : taskManager.getTasks()) {
            taskList.getItems().add(task.toString());
        }
    }
}
