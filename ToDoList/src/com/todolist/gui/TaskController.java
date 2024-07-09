package com.todolist.gui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.Task;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TaskController {

    @FXML
    private TextField taskInput;

    @FXML
    private ListView<String> taskList;

    @FXML
    private void handleAddTask() {
        String taskDescription = taskInput.getText();
        if (!taskDescription.isEmpty()) {
            addTaskToBackend(taskDescription);
            taskInput.clear();
            loadTasksFromBackend();
        }
    }

    private void addTaskToBackend(String taskDescription) {
        try {
            URL url = new URL("http://localhost:8081/tasks");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonInputString = objectMapper.writeValueAsString(new Task(taskDescription));

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                showError("Failed to add task");
            }

            connection.disconnect();
        } catch (IOException e) {
            showError("Error connecting to backend: " + e.getMessage());
        }
    }

    private void loadTasksFromBackend() {
        try {
            URL url = new URL("http://localhost:8081/tasks");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                List<String> tasks = objectMapper.readValue(connection.getInputStream(), List.class);
                ObservableList<String> observableTasks = FXCollections.observableArrayList(tasks);
                taskList.setItems(observableTasks);
            } else {
                showError("Failed to load tasks");
            }

            connection.disconnect();
        } catch (IOException e) {
            showError("Error connecting to backend: " + e.getMessage());
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
