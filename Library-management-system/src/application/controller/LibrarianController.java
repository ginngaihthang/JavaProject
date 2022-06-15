package application.controller;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.MainLib;
import application.entry.Librarians;
import application.model.DatabaseService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class LibrarianController implements Initializable{
	
	@FXML
    private TableColumn<Librarians, LocalDate> col_birthday;

    @FXML
    private TableColumn<Librarians, String> col_city;

    @FXML
    private TableColumn<Librarians, Integer> col_id;

    @FXML
    private TableColumn<Librarians, String> col_name;

    @FXML
    private TableView<Librarians> tbl_librarian;

    @FXML
    private DatePicker txt_birthday;

    @FXML
    private TextField txt_city;
    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_name;

    private List<Librarians> libraryList;
    @FXML
    void btn_add_click(ActionEvent event) {
    	String name = txt_name.getText();
    	String city = txt_city.getText();
    	LocalDate birthday = txt_birthday.getValue();
    	
    	
    	if(name.isEmpty()) {
    		showAlert(AlertType.WARNING, "Please enter Author name!");
    		return;
    	}
    	if(city.isEmpty()) {
    		showAlert(AlertType.WARNING, "Please enter Author city!");
    		return;
    	}
    	if(birthday == null) {
    		showAlert(AlertType.WARNING, "Please enter Author birthday!");
    		return;
    	}
    	DatabaseService.saveLibrarian(name, city, birthday);
    	
    	Clear();
    	loadLibrary();
    }

    

	private void Clear() {
		txt_name.setText(null);
    	txt_city.setText(null);
    	txt_birthday.setValue(null);
		
	}
	
	private Optional<ButtonType> showAlert(AlertType warning, String string) {
    	Alert alert = new Alert(warning);
    	alert.setContentText(string);
    	alert.setTitle("Message");
    	alert.setHeaderText(null);
    	Optional<ButtonType> result = alert.showAndWait();
		return result;
	}


	@FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	MainLib.change_scene("view/Main.fxml");
    }

    @FXML
    void btn_delete_click(ActionEvent event) {
    	var library = tbl_librarian.getSelectionModel().getSelectedItem();
    	if(library != null  ) {
    		var output = showAlert(AlertType.CONFIRMATION, "Are you sure to delete?");
    		if(output.get() == ButtonType.OK) {
    			DatabaseService.deleteWithAuthorId(library.getId());
    			Clear();
    			loadLibrary();
    		}
    	}
    }

    @FXML
    void btn_update_click(ActionEvent event) {
    	String name = txt_name.getText();
    	String city = txt_city.getText();
    	LocalDate birthday = txt_birthday.getValue();
    	var library = tbl_librarian.getSelectionModel().getSelectedItem();
    	library.setName(name);
    	library.setCity(city);
    	library.setBirthday(birthday);
    	DatabaseService.UpdateLibrary(library);
    	Clear();
    	loadLibrary();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_city.setCellValueFactory(new PropertyValueFactory<>("city"));
		col_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		
		loadLibrary();
		tbl_librarian.getSelectionModel().selectedItemProperty().addListener(
			(obs, old_select, new_select) -> {
				if(new_select != null) {
					var librarian = tbl_librarian.getSelectionModel().getSelectedItem();
					txt_name.setText(librarian.getName());
					txt_city.setText(librarian.getCity());
				   	txt_birthday.setValue(librarian.getBirthday());
				}
			}
		);
		
	}
	private void loadLibrary() {
		libraryList = DatabaseService.findAllLibrarians();
		tbl_librarian.setItems(FXCollections.observableArrayList(libraryList));
	}

}
