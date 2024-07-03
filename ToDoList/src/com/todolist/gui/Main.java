package com.todolist.gui;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	 public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TaskView.fxml"));
        primaryStage.setTitle("To-Do List");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}
