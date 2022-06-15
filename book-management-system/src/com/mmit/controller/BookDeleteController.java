package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.mmit.Start;
import com.mmit.model.entity.Author;
import com.mmit.model.entity.Book;
import com.mmit.model.entity.Category;
import com.mmit.model.service.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class BookDeleteController implements Initializable{

	 @FXML
	    private TableColumn<Book, String> col_author;

	    @FXML
	    private TableColumn<Book, String> col_category;

	    @FXML
	    private TableColumn<Book, String> col_created_at;

	    @FXML
	    private TableColumn<Book, Integer> col_id;

	    @FXML
	    private TableColumn<Book, Integer> col_price;

	    @FXML
	    private TableColumn<Book, LocalDate> col_publish_date;

	    @FXML
	    private TableColumn<Book, String> col_title;

	    @FXML
	    private TableView<Book> tbl_book;

	    private List<Book> bookList;
	   
	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	
	    	Start.change_scene("view/Books.fxml");
	    }

	    @FXML
	    void btn_delete_click(ActionEvent event) {
	    	var book = tbl_book.getSelectionModel().getSelectedItem();
	    	if(book != null) {
	    		Alert alert = new Alert(AlertType.CONFIRMATION);
	    		alert.setContentText("Are you surce to delete?");
		    	Optional<ButtonType> result = alert.showAndWait();
		    	if(result.get() == ButtonType.OK) {
		    		DatabaseService.deleteBookByCode(book.getCode());
		    		loadBooks();
		    	}
	    	}
	    	
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			col_id.setCellValueFactory(new PropertyValueFactory<>("code"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
			col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
			col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
			col_publish_date.setCellValueFactory(new PropertyValueFactory<>("publist_date"));
			col_created_at.setCellValueFactory(new PropertyValueFactory<>("userName"));
		
			loadBooks();
		}

		private void loadBooks() {
			bookList = DatabaseService.viewAllBooks();
		
			tbl_book.setItems(FXCollections.observableArrayList(bookList));
		}

		
		
		
}
