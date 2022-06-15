package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Register_controller implements Initializable{
	@FXML
    private ComboBox<String> cbo_city;

    @FXML
    private CheckBox chk_java;

    @FXML
    private CheckBox chk_javascript;

    @FXML
    private CheckBox chk_php;

    @FXML
    private ToggleGroup rad_group;

    @FXML
    private TextArea txt_area;

    @FXML
    private DatePicker txt_dob;

    @FXML
    private TextField txt_name;

    @FXML
    private PasswordField txt_password;

    @FXML
    void btn_login_click(ActionEvent event) throws IOException {
    	Main.changeScence("Sample.fxml");
    }

    @FXML
    void btn_register_click(ActionEvent event) {
    	String name = txt_name.getText();
    	String pass = txt_password.getText();
    	LocalDate dob = txt_dob.getValue();
    	
    	// selected index
    	
    	int selected_index = cbo_city.getSelectionModel().getSelectedIndex();
    	
    	//selected item
    	String selected_item = cbo_city.getSelectionModel().getSelectedItem();
    	String skillsets = "";
    	if(chk_java.isSelected()) {
    		skillsets += chk_java.getText();
    	}
    	if(chk_php.isSelected()) {		
    		skillsets += chk_php.getText();
    	}
    	if(chk_javascript.isSelected()) {
    		skillsets += chk_javascript.getText();    	
    	}
    	RadioButton selected_radio = (RadioButton) rad_group.getSelectedToggle();
    	
    	String gender = selected_radio.getText();
    	String others = txt_area.getText();
    	System.out.println("----- Your Profile -----");
    	System.out.println("Name: " + name);
    	System.out.println("Password: " + pass);
    	System.out.println("Birthday:" +dob);
    	System.out.println("City: " + selected_item +"(" + selected_index + ")");
    	System.out.println("Skillsets: "+ skillsets );
    	System.out.println("Gender: " + gender);
    	System.out.println("Other dInformation: " + others);
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		List<String> cities =List.of("Yangon","Mandalay","Pyin Oo Lwin");
		cbo_city.setItems(FXCollections.observableArrayList(cities));
	}
}
