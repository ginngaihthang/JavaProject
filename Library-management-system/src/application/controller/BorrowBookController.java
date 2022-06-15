package application.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

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

public class BorrowBookController implements Initializable{


	@FXML
    private TableColumn<Borrows, Integer> col_book_id;

    @FXML
    private TableColumn<Borrows, LocalDate> col_borrow_date;

    @FXML
    private TableColumn<Borrows, LocalDate> col_due_date;

    @FXML
    private TableColumn<Borrows, Integer> col_fees;

    @FXML
    private TableColumn<Borrows, Integer> col_id;

    @FXML
    private TableColumn<Borrows, Integer> col_librarian;

    @FXML
    private TableColumn<Borrows, Integer> col_member_id;

    @FXML
    private TableColumn<Borrows, LocalDate> col_return_date;
    
    @FXML
    private TableView<Borrows> tbl_borrow;

    @FXML
    private TextField txt_book_id;

    @FXML
    private TextField txt_member_id;

    private List<Borrows> borrowList;
    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	MainLib.change_scene("view/Main.fxml");
    }

    @FXML
    
    void btn_borrow_click(ActionEvent event) {
    	LocalDate now =LocalDate.now();
    	String member_id= txt_member_id.getText();
    	String book_id = txt_book_id.getText();
    	var m = DatabaseService.findMemberCard(member_id);
    	var b = DatabaseService.findBookCode(book_id);
    	if(m.getExpried_date().isBefore(now)) {
    		showAlert(AlertType.ERROR, "Card is date out");
    	}else if(b.getAvaliable() == 1){
    		showAlert(AlertType.ERROR, "Book is not avaliable now");
    	}
    	else if(b.getAvaliable() == 0) {
//    		DatabaseService.borrowBooks(m,b);
    		DatabaseService.UpdateAvaliable(b);
    		Borrows borr = new Borrows();
    		borr.setMember(m);
    		borr.setBook(b);
    		borr.setBorrow_date(now);
    		borr.setDue_date(now.plusDays(7));
    		borr.setReturn_date(null);
    		borr.setFees(0);
    		borr.setCreated_by(LoginController.login_user);
    		if(DatabaseService.borrowBook(borr)) {
    			loadBorrows();
    		}		
    	}
    }

	private void showAlert(AlertType error, String string) {
		Alert alert = new Alert(error);
		alert.setContentText(string);
		alert.setHeaderText(null);
		alert.setTitle("Message");
		alert.showAndWait();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_member_id.setCellValueFactory(new PropertyValueFactory<>("card_id"));
		col_book_id.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_borrow_date.setCellValueFactory(new PropertyValueFactory<>("borrow_date"));
		col_return_date.setCellValueFactory(new PropertyValueFactory<>("return_date"));
		col_due_date.setCellValueFactory(new PropertyValueFactory<>("due_date"));
		col_fees.setCellValueFactory(new PropertyValueFactory<>("fees"));
		col_librarian.setCellValueFactory(new PropertyValueFactory<>("librianName"));
		loadBorrows();
	}

	private void loadBorrows() {
		borrowList = DatabaseService.findAllBorrows();
		tbl_borrow.setItems(FXCollections.observableArrayList(borrowList));
		
	}
}
