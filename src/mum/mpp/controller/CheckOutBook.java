package mum.mpp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import mum.mpp.model.*;
import mum.mpp.util.LibraryUtil;

import java.time.LocalDate;

public class CheckOutBook {

    @FXML
    private JFXTextField memberId;
    @FXML
    private JFXTextField bookIsdn;
    @FXML
    private JFXButton checkOutButton;

    @FXML
    public void checkOutBook(ActionEvent ae) {
        String libMemberId = memberId.getText();
        String isbn = bookIsdn.getText();

        Book selectedBook = null;
        LibraryMember selectedLibraryMember = null;

        for (Book book : ApplicationInitialDB.books) {
            if (book.getIsbn().equals(isbn)) {
                selectedBook = book;
            }
        }
        for (LibraryMember libraryMember : ApplicationInitialDB.libraryMembers) {
            if (libraryMember.getMemberId().equals(libMemberId)) {
                selectedLibraryMember = libraryMember;
            }
        }
        if (selectedBook == null) {
            LibraryUtil.createNewAlert("Book Not Found !", "Please Enter a valid ISBN number");
        } else if (selectedLibraryMember == null) {
            LibraryUtil.createNewAlert("Library Member Not Found !", "Please Enter a valid Library Member ID");
        } else {
            BookCopy bookCopy = selectedBook.getAvailableCopy();
            if (bookCopy != null) {


                LocalDate now = LocalDate.now();
                LocalDate dueDate = now.plusDays(selectedBook.getBorrowModel());
                selectedLibraryMember.getCheckOutRecord().addCheckOutEntry(now,dueDate,bookCopy);
                LibraryUtil.createNewAlert("Checked Out Successfully",
                        "Book Copy id :" + bookCopy.getCopyId() + "\n checked out to  " + selectedLibraryMember.getFirstName() + "  " + selectedLibraryMember.getLastName());

            } else {
                LibraryUtil.createNewAlert("No Available Copies !", "Sorry There is no available copies for this Book, please choose another book");
            }

        }

    }
}
