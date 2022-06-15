package application.controller;

import java.io.IOException;

import application.MainLib;
import application.entry.Librarians;
import application.entry.Users;
import application.model.DatabaseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginController {
	@FXML
    private TextField txt_email;

    @FXML
    private TextField txt_password;

    public static Librarians login_user;
    @FXML
    void btn_back_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void btn_clear_click(ActionEvent event) {
    	txt_email.setText(null);
    	txt_password.setText(null);
    }

    @FXML
    void btn_login_click(ActionEvent event) throws IOException {
    	String email = txt_email.getText();
    	String password = txt_password.getText();
    	var user = DatabaseService.login(email, password);
    	if(user != null) {
    		login_user = user;
    		MainLib.change_scene("view/Main.fxml");
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("You are not authenticated");
    		alert.setHeaderText(null);
    		alert.setTitle("Message");
    		alert.showAndWait();
    	}
    }
}
