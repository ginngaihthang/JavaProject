package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.MainLib;
import application.entry.Books;
import application.model.DatabaseService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class DeleteBookController implements Initializable{

	   @FXML
	    private TableColumn<Books, String> col_author;

	    @FXML
	    private TableColumn<Books, Integer> col_avaliable;

	    @FXML
	    private TableColumn<Books, String> col_category;

	    @FXML
	    private TableColumn<Books, Integer> col_code;

	    @FXML
	    private TableColumn<Books, String> col_title;

	    @FXML
	    private TableView<Books> tbl_book;

	    private List<Books> bookList;
	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	MainLib.change_scene("view/Book.fxml");
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
			col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
			col_avaliable.setCellValueFactory(new PropertyValueFactory<>("avaliable"));
			col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
			
			loadBooks();
			
		}

		private void loadBooks() {
			bookList = DatabaseService.findAllBooks();
			tbl_book.setItems(FXCollections.observableArrayList(bookList));
		}
}
