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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddBookController implements Initializable{
	@FXML
    private ComboBox<String> cbo_author;

    @FXML
    private ComboBox<String> cbo_category;

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
    private TextField txt_code;

    @FXML
    private TextField txt_title;

    private List<Books> bookList;
    private List<Authors> authorList;
    private List<Categories> categoryList;
    @FXML
    void btn_home_click(ActionEvent event) throws IOException {
    	MainLib.change_scene("view/Book.fxml");
    }

    @FXML
    void btn_reset_click(ActionEvent event) {
    	txt_code.setText(null);
    	txt_title.setText(null);
    	cbo_category.setValue(null);
    	cbo_author.setValue(null);
    }

    @FXML
    void btn_save_click(ActionEvent event) {
    	String code = txt_code.getText();
    	String title = txt_title.getText();
    	
    	int author_index = cbo_author.getSelectionModel().getSelectedIndex();
    	int category_index = cbo_category.getSelectionModel().getSelectedIndex();
    	
    	if(code.isEmpty()) {
    		showAlert(AlertType.WARNING, "Please enter Book code");
    		return;
    	}
    	if(title.isEmpty()) {
    		showAlert(AlertType.WARNING, "Please enter Book title");
    		return;
    	}
    	if(author_index == -1) {
    		showAlert(AlertType.WARNING, "Please choose author");
    		return;
    	}
    	if(category_index == -1) {
    		showAlert(AlertType.WARNING, "Please choose category");
    		return;
    	}
    	
    	Books book = new Books();
    	book.setCode(Integer.parseInt(code));
    	book.setTitle(title);
    	book.setAuthor(authorList.get(author_index));
    	book.setCategory(categoryList.get(category_index));
    	var bookslist = DatabaseService.saveBooks(book);
    	
    	if(bookslist) {
    		showAlert(AlertType.INFORMATION, "New Book is inserted");
    		loadBooks();
    	}
    	else {
    		showAlert(AlertType.ERROR, "Something is wrong");
    	}
    }

	private void showAlert(AlertType warning, String string) {
		Alert alert = new Alert(warning);
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
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		loadBooks();
		loadAuthor();
		loadCategory();
	}

	private void loadBooks() {
		bookList = DatabaseService.findAllBooks();
		tbl_book.setItems(FXCollections.observableArrayList(bookList));
		
	}

	private void loadCategory() {
		categoryList = DatabaseService.findAllCategories();
		
		List<String> names = categoryList.stream()
								.map(n -> n.getName())
								.toList();
		cbo_category.setItems(FXCollections.observableArrayList(names));
		
	}

	private void loadAuthor() {
		authorList = DatabaseService.findAllAuthors();
		List<String> names = authorList.stream()
								.map(n -> n.getName())
								.toList();
		cbo_author.setItems(FXCollections.observableArrayList(names));
		
		
	}
}
