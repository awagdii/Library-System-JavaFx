package mum.mpp.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import mum.mpp.business.ServicesImp;
import mum.mpp.dao.ApplicationInitialDB;
import mum.mpp.model.Book;
import mum.mpp.model.BookCopy;
import mum.mpp.util.LibraryUtil;

import java.util.UUID;

public class AddCopies {

    @FXML
    JFXTextField isbn;
    @FXML
    JFXTextField copyNumber;

    private ServicesImp serviceImp=ServicesImp.getServicesImp();

    @FXML
    public void submit(ActionEvent ae) {

        String isbnNumber = isbn.getText();
        try {

            int numberOfCopies = Integer.parseInt(copyNumber.getText());
            Book selectedBook = null;
            for (Book book : serviceImp.getBooks()) {
                if (book.getIsbn().equals(isbnNumber)) {
                    selectedBook = book;
                }
            }

            if (selectedBook != null) {
                for (int i = 0; i < numberOfCopies; i++) {
                    selectedBook.addBookCopy(UUID.randomUUID().toString(),selectedBook);
                }
                ApplicationInitialDB.saveAllBooks();
                LibraryUtil.createNewAlert("Book Added Successfully!", "Successfully Added a new Copy for Book :" + selectedBook.getTitle());
            } else {
                LibraryUtil.createNewAlert("Book Not Found !", "Please Enter a valid ISBN number");
            }
        } catch (Exception e) {
            LibraryUtil.createNewAlert("Number of Copies is invalid", "please enter a valid number");
        }

    }
}