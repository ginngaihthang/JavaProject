package application.controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchBookController implements Initializable{


    @FXML
    private TableColumn<Authors, String> col_author;

    @FXML
    private TableColumn<Books, Integer> col_avaliable;

    @FXML
    private TableColumn<Categories, String> col_category;

    @FXML
    private TableColumn<Books, Integer> col_code;

    @FXML
    private TableColumn<Books, String> col_title;

    @FXML
    private TableView<Books> tbl_book;

    @FXML
    private TextField txt_author;

    @FXML
    private TextField txt_category;

    @FXML
    private TextField txt_code;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	MainLib.change_scene("view/Book.fxml");
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	String code = txt_code.getText();
    	String author = txt_author.getText();
    	String category = txt_category.getText();
    	String avaliable = txt_author.getText();
    	var bookList = DatabaseService.searchBooks(code, author, category, avaliable);
    	if(bookList.size() > 0) {
    		tbl_book.setItems(FXCollections.observableArrayList(bookList));
    	}
    	else {
    		showAlert(AlertType.ERROR, "Does not exist");
    	}
    }

	private void showAlert(AlertType error, String string) {
		Alert alert = new Alert(error);
		alert.setContentText(string);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_avaliable.setCellValueFactory(new PropertyValueFactory<>("avaliable"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		
	}
}
