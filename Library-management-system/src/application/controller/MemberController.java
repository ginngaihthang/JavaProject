package application.controller;

import java.io.IOException;
import java.lang.reflect.Member;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import application.MainLib;
import application.entry.Members;
import application.model.DatabaseService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberController implements Initializable{
	  @FXML
	    private TableColumn<Members, String> col_academic_year;

	    @FXML
	    private TableColumn<Members, Integer> col_card_id;

	    @FXML
	    private TableColumn<Members, String> col_class_year;

	    @FXML
	    private TableColumn<Members, LocalDate> col_create_date;

	    @FXML
	    private TableColumn<Members, LocalDate> col_experied_date;

	    @FXML
	    private TableColumn<Members, String> col_name;

	    @FXML
	    private TableColumn<Members, Integer> col_roll_no;

	    @FXML
	    private TableView<Members> tbl_member;

	    @FXML
	    private TextField txt_academic_year;

	    @FXML
	    private TextField txt_card_id;

	    @FXML
	    private TextField txt_class_year;

	    @FXML
	    private DatePicker txt_create_date;

	    @FXML
	    private DatePicker txt_experied_date;

	    @FXML
	    private TextField txt_name;

	    @FXML
	    private TextField txt_roll_no;

	    @FXML
	    private DatePicker txt_search_experied;

	    @FXML
	    private TextField txt_search_name;

	    private  List<Members> memberList;
	    @FXML
	    void btn_add_click(ActionEvent event) {
	    	String card = txt_card_id.getText();
	    	String name = txt_name.getText();
	    	String roll = txt_roll_no.getText();
	    	String class_year = txt_class_year.getText();
	    	String academic = txt_academic_year.getText();
	    	LocalDate register = txt_create_date.getValue();
	    	LocalDate expried = txt_experied_date.getValue();
	    	if(card.isEmpty()) {
	    		showAlert(AlertType.WARNING, "please enter Card Id");
	    		return;
	    	}
	    	if(name.isEmpty()) {
	    		showAlert(AlertType.WARNING, "please enter Name");
	    		return;
	    	}
	    	if(roll.isEmpty()) {
	    		showAlert(AlertType.WARNING, "please enter Roll Number");
	    		return;
	    	}
	    	if(class_year.isEmpty()) {
	    		showAlert(AlertType.WARNING, "please enter Class Year");
	    		return;
	    	}
	    	if(academic.isEmpty()) {
	    		showAlert(AlertType.WARNING, "please enter Academic Year");
	    		return;
	    	}
	    	if(register == null) {
	    		showAlert(AlertType.WARNING, "please enter Register date");
	    		return;
	    	}
	    	if(expried == null) {
	    		showAlert(AlertType.WARNING, "please enter Expried date");
	    		return;
	    	}
	    	
	    	Members member = new Members();
	    	member.setCard_id(Integer.parseInt(card));
	    	member.setName(name);
	    	member.setRoll_no(Integer.parseInt(roll));
	    	member.setClass_year(class_year);
	    	member.setAcademic_year(academic);
	    	member.setRegister_date(register);
	    	member.setExpried_date(expried);
	    	if(DatabaseService.saveMembers(member)) {
	    		showAlert(AlertType.CONFIRMATION, "New Member is successfully inserted");
	    	}
	    	else {
	    		showAlert(AlertType.ERROR, "Something is worng");
	    	}
	    	loadMembers();
	    }

	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	MainLib.change_scene("view/Main.fxml");
	    }

	    @FXML
	    void btn_edit_click(ActionEvent event) {
	    	Members member = new Members();
	    	member.setCard_id(Integer.parseInt(txt_card_id.getText()));
	    	member.setName(txt_name.getText());
	    	member.setRoll_no(Integer.parseInt(txt_roll_no.getText()));
	    	member.setClass_year(txt_class_year.getText());
	    	member.setAcademic_year(txt_academic_year.getText());
	    	member.setRegister_date(txt_create_date.getValue());
	    	member.setExpried_date(txt_experied_date.getValue());
	    	
	    	if(DatabaseService.UpdateMembers(member)) {
	    		showAlert(AlertType.INFORMATION, "Update success");
	    	}
	    	else {
	    		showAlert(AlertType.ERROR, "Something is wrong");
	    	}
	    	loadMembers();
	    }

	    @FXML
	    void btn_reset_click(ActionEvent event) {
	    	txt_card_id.setText(null);
	    	txt_name.setText(null);
	    	txt_roll_no.setText(null);
	    	txt_class_year.setText(null);
	    	txt_academic_year.setText(null);
	    	txt_create_date.setValue(null);
	    	txt_experied_date.setValue(null);
	    }

	    @FXML
	    void btn_search_click(ActionEvent event) {
	    	String name = txt_search_name.getText();
	    	LocalDate expried = txt_search_experied.getValue();
	    	if(name.isEmpty()) {
	    		showAlert(AlertType.WARNING, "plese enter name to search");
	    		return;
	    	}
	    	if(expried == null) {
	    		showAlert(AlertType.WARNING, "plese enter expried date to search");
	    		return;
	    	}
	    	var membersList = DatabaseService.searchMembers(name, expried);
	    	if(membersList.size() > 0) {
	    		tbl_member.setItems(FXCollections.observableArrayList(membersList));
	    	}
	    	else {
	    		showAlert(AlertType.WARNING, "Does not exist");
	    	}
	    }

		private void showAlert(AlertType information, String string) {
			Alert alert = new Alert(information);
			alert.setContentText(string);
			alert.setTitle("Message");
			alert.setHeaderText(null);
			alert.showAndWait();
			
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			col_card_id.setCellValueFactory(new PropertyValueFactory<>("card_id"));
			col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
			col_roll_no.setCellValueFactory(new PropertyValueFactory<>("roll_no"));
			col_class_year.setCellValueFactory(new PropertyValueFactory<>("class_year"));
			col_academic_year.setCellValueFactory(new PropertyValueFactory<>("academic_year"));
			col_create_date.setCellValueFactory(new PropertyValueFactory<>("register_date"));
			col_experied_date.setCellValueFactory(new PropertyValueFactory<>("expried_date"));
			loadMembers();
			tbl_member.getSelectionModel().selectedItemProperty().addListener(
					(obs, old_select, new_select) -> {
						if(new_select != null) {
							var member = tbl_member.getSelectionModel().getSelectedItem();
							txt_card_id.setText(Integer.toString(member.getCard_id()));
							txt_name.setText(member.getName());
							txt_roll_no.setText(Integer.toString(member.getRoll_no()));
							txt_class_year.setText(member.getClass_year());
							txt_academic_year.setText(member.getAcademic_year());
							txt_create_date.setValue(member.getRegister_date());
							txt_experied_date.setValue(member.getExpried_date());
						}
					}
			);
		}

		private void loadMembers() {
			memberList = DatabaseService.findAllMembers();
			
			tbl_member.setItems(FXCollections.observableArrayList(memberList));
		}
}
