  package com.mmit;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.fxml.FXMLLoader;


public class Start extends Application {
	static Stage original_stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
			Scene scene = new Scene(root);
			original_stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void change_scene(String input_file) throws IOException {
		Parent root = FXMLLoader.load(Start.class.getResource(input_file));
		Scene scene = new Scene(root);
		original_stage.hide();
		original_stage.setScene(scene);
		original_stage.setResizable(false);
		original_stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
