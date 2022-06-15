package application.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

import application.MainLib;
import application.entry.Borrows;
import application.model.DatabaseService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReturnBookController implements Initializable{


    @FXML
    private TableColumn<Borrows, Integer> col_book_id;

    @FXML
    private TableColumn<Borrows, LocalDate> col_borrow_date;

    @FXML
    private TableColumn<Borrows, Integer> col_borrow_id;

    @FXML
    private TableColumn<Borrows, LocalDate> col_due_date;

    @FXML
    private TableColumn<Borrows, Integer> col_fees;

    @FXML
    private TableColumn<Borrows, Integer> col_member_id;

    @FXML
    private TableColumn<Borrows, LocalDate> col_return_date;

    @FXML
    private TableView<Borrows> tbl_return;

    @FXML
    private TextField txt_card_id;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	MainLib.change_scene("view/Main.fxml");
    }

    @FXML
    void btn_confrim_click(ActionEvent event) {
    	var rebook = tbl_return.getSelectionModel().getSelectedItem();
    	if(rebook.getDue_date().isBefore(LocalDate.now())) {
    		
    		DatabaseService.BookFees(rebook);
    	}
    	if(DatabaseService.returnBorrowBook(rebook)) {
    		DatabaseService.borrowBookAvaliable(rebook);
    	}
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	String card_id = txt_card_id.getText();
    	var returnList = DatabaseService.searchBorrowBook(card_id);
    	if(returnList.size() > 0) {
    		tbl_return.setItems(FXCollections.observableArrayList(returnList));
    	}
    	else{
    		showAlert(AlertType.ERROR, "Does not exist!");
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
		col_borrow_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_member_id.setCellValueFactory(new PropertyValueFactory<>("card_id"));
		col_book_id.setCellValueFactory(new PropertyValueFactory<>("book_id"));
		col_borrow_date.setCellValueFactory(new PropertyValueFactory<>("borrow_date"));
		col_due_date.setCellValueFactory(new PropertyValueFactory<>("due_date"));
		col_fees.setCellValueFactory(new PropertyValueFactory<>("fees"));
		col_return_date.setCellValueFactory(new PropertyValueFactory<>("return_date"));
		
		
	}
}
