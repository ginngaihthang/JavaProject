package com.mmit.controller;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.entity.Author;
import com.mmit.model.service.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AuthorsController implements Initializable{
	
	@FXML
    private TableColumn<Author, LocalDate> col_birthday;

    @FXML
    private TableColumn<Author, String> col_city;

    @FXML
    private TableColumn<Author, LocalDateTime> col_created_at;

    @FXML
    private TableColumn<Author, Integer> col_id;

    @FXML
    private TableColumn<Author, String> col_name;

    @FXML
    private TableColumn<Author, LocalDateTime> col_updated_at;

    @FXML
    private TableView<Author> tbl_author;

    @FXML
    private DatePicker txt_birthday;

    @FXML
    private TextField txt_city;

    @FXML
    private TextField txt_name;

    private List<Author> authorList;
    @FXML
    void btn_add_click(ActionEvent event) {
    	String name = txt_name.getText();
    	String city = txt_city.getText();
    	LocalDate birthday = txt_birthday.getValue();
    	if(name.isEmpty()) {
    		showAlert(AlertType.WARNING, "Please enter name");
    		return;
    	}
    	if(city.isEmpty()) {
    		showAlert(AlertType.WARNING, "Please enter city");
    		return;
    	}
    	if(birthday == null) {
    		showAlert(AlertType.WARNING, "Please enter birthday");
    		return;
    	}
    	DatabaseService.AuthorSave(name, city, birthday);
    	Clear();
    	loadAuthors();
    }

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.change_scene("view/Main.fxml");
    }

    @FXML
    void btn_delete_click(ActionEvent event) {
    	var author = tbl_author.getSelectionModel().getSelectedItem();
    	if(author != null ) {
    		var output = showAlert(AlertType.CONFIRMATION,"Are you sure to delete?");
    		if(output.get() == ButtonType.OK) {
    			DatabaseService.deleteByAuthorId(author.getId());
    			Clear();
    			loadAuthors();
    		}
    	}
    }

    @FXML
    void btn_update_click(ActionEvent event) {
    	String name = txt_name.getText();
    	String city = txt_city.getText();
    	LocalDate birthday = txt_birthday.getValue();
    	Author author = tbl_author.getSelectionModel().getSelectedItem();
    	author.setName(name);
    	author.setCity(city);
    	author.setBirthday(birthday);
    	
    	DatabaseService.AuthorUpdate(author);
    	Clear();    	
    	loadAuthors();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_city.setCellValueFactory(new PropertyValueFactory<>("city"));
		col_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		col_created_at.setCellValueFactory(new PropertyValueFactory<>("created_at"));
		col_updated_at.setCellValueFactory(new PropertyValueFactory<>("updated_at"));
		loadAuthors();
		tbl_author.getSelectionModel().selectedItemProperty().addListener(
			(obs, old_select, new_select) -> {
				if(new_select != null) {
					var author = tbl_author.getSelectionModel().getSelectedItem();
					txt_name.setText(author.getName());
					txt_city.setText(author.getCity());
				   	txt_birthday.setValue(author.getBirthday());
				}
			}
		);
	}
	private void Clear() {
		txt_name.setText(null);
    	txt_city.setText(null);
    	txt_birthday.setValue(null);
	}
	private Optional<ButtonType> showAlert(AlertType type, String body) {
		Alert alert = new Alert(type);
		alert.setContentText(body);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		Optional<ButtonType> result = alert.showAndWait();
		
		return result;
	}
	private void loadAuthors() {
		authorList = DatabaseService.viewAllAuthors();
		
		tbl_author.setItems(FXCollections.observableArrayList(authorList));
	}

}
