package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SampleController {
	@FXML
	private TextField text_name;
	@FXML
	private PasswordField text_password;
	@FXML
	private Label lbl_result;
	@FXML
	public void btn_login_click() {
		String name = text_name.getText();
		String pass = text_password.getText();
		
		if(name.isEmpty()) {
			lbl_result.setText("Please enter name");
			return;
		}
		if(pass.isEmpty()) {
			lbl_result.setText("Please enter password");
			return;
		}
		
		if(name.equals("mmit") && pass.equals("admin")) {
			lbl_result.setText("Login Success");
		}
		else {
			lbl_result.setText("Invalid Login");
		}
	}
	@FXML
	public void btn_login_clear() {
		text_name.setText("");
		text_password.setText(null);
	}
	@FXML
	public void lbl_click() throws IOException {
		Main.changeScence("Register.fxml");
	}
}
