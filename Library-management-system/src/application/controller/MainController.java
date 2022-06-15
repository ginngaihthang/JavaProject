package application.controller;

import java.io.IOException;

import application.MainLib;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MainController {
	
	 @FXML
	    void author_click(MouseEvent event) throws IOException {
		 	MainLib.change_scene("view/Author.fxml");
	    }

	    @FXML
	    void book_click(MouseEvent event) throws IOException {
	    	MainLib.change_scene("view/Book.fxml");
	    }

	    @FXML
	    void borrow_click(MouseEvent event) throws IOException {
	    	MainLib.change_scene("view/Borrow.fxml");
	    }

	    @FXML
	    void btn_logout_click(ActionEvent event) {
	    	System.exit(0);
	    }

	    @FXML
	    void category_click(MouseEvent event) throws IOException {
	    	MainLib.change_scene("view/Category.fxml");
	    }

	    @FXML
	    void librarian_click(MouseEvent event) throws IOException {
	    	MainLib.change_scene("view/Librarian.fxml");
	    }

	    @FXML
	    void member_click(MouseEvent event) throws IOException {
	    	MainLib.change_scene("view/Members.fxml");
	    }

	    @FXML
	    void return_click(MouseEvent event) throws IOException {
	    	MainLib.change_scene("view/Return.fxml");
	    }
}
