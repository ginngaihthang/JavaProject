package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.MainLib;
import application.entry.Authors;
import application.entry.Books;
import application.entry.Categories;
import application.model.DatabaseService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EditBookController implements Initializable{

    @FXML
    private ComboBox<String> cbo_author;

    @FXML
    private ComboBox<String> cbo_category;

    @FXML
    private TextField txt_code;

    @FXML
    private TextField txt_title;

    private List<Authors> authorList;
    private List<Categories> categoryList;
    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	MainLib.change_scene("view/Book.fxml");
    }

    @FXML
    void btn_clear_click(ActionEvent event) {
    	txt_code.setText(null);
    	txt_title.setText(null);
    	cbo_author.setValue(null);
    	cbo_category.setValue(null);
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	String code = txt_code.getText();
    	if(code.isEmpty()) {
    		showAlert(AlertType.WARNING, "Please enter code");
    		return;
    	}
    	Books book = DatabaseService.findBookByCode(code);
    	
    	if(book != null) {
    		txt_title.setText(book.getTitle());
    		cbo_author.getSelectionModel().select(book.getAuthorName());
    		cbo_category.getSelectionModel().select(book.getCategoryName());
    	}
    	else {
    		showAlert(AlertType.ERROR, "There is no book with this code");
    	}
    }

    private void showAlert(AlertType warning, String string) {
		Alert alert = new Alert(warning);
		alert.setContentText(string);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.showAndWait();
		
	}
    @FXML
    void btn_update_click(ActionEvent event) {
    	Books book = new Books();
    	book.setCode(Integer.parseInt(txt_code.getText()));
    	book.setTitle(txt_title.getText());
    	var auth_index = cbo_author.getSelectionModel().getSelectedIndex();
    	var cate_index = cbo_category.getSelectionModel().getSelectedIndex();
    	
    	book.setAuthor(authorList.get(auth_index));
    	book.setCategory(categoryList.get(cate_index));
    	if(DatabaseService.updateBooks(book)) {
    		showAlert(AlertType.INFORMATION, "Book is successfully updated");
    	}
    	else {
    		showAlert(AlertType.ERROR, "Somethings is wrong");
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		authorList = DatabaseService.findAllAuthors();
		categoryList = DatabaseService.findAllCategories();
		
		var author_name = authorList.stream()
							.map(n -> n.getName())
							.toList();
		var category_name = categoryList.stream()
								.map(n -> n.getName())
								.toList();
		cbo_author.setItems(FXCollections.observableArrayList(author_name));
		cbo_category.setItems(FXCollections.observableArrayList(category_name));
	}
}
