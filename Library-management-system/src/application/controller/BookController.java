package application.controller;

import java.io.IOException;

import application.MainLib;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class BookController {


    @FXML
    void add_book_click(MouseEvent event) throws IOException {
    	MainLib.change_scene("view/AddBook.fxml");
    }

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	MainLib.change_scene("view/Main.fxml");
    }

    @FXML
    void delete_book_click(MouseEvent event) throws IOException {
    	MainLib.change_scene("view/DeleteBook.fxml");
    }

    @FXML
    void edit_book_click(MouseEvent event) throws IOException {
    	MainLib.change_scene("view/EditBook.fxml");
    }

    @FXML
    void search_book_click(MouseEvent event) throws IOException {
    	MainLib.change_scene("view/SearchBook.fxml");
    }
}
