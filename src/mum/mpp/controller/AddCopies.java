package mum.mpp.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import mum.mpp.model.ApplicationInitialDB;
import mum.mpp.model.Book;
import mum.mpp.util.LibraryUtil;

public class AddCopies {

    @FXML
    JFXTextField isbn;

    @FXML
    public void submit(ActionEvent ae) {

        String isbnNumber = isbn.getText();
        Book selectedBook=null;
        for (Book book : ApplicationInitialDB.books) {
            if (book.getIsbn().equals(isbnNumber)) {
                selectedBook = book;
            }
        }

        if(selectedBook!=null){
            
        }else {
            LibraryUtil.createNewAlert("Book Not Found !", "Please Enter a valid ISBN number");
        }

    }
}