package mum.mpp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import mum.mpp.model.*;
import mum.mpp.util.LibraryUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckOutBook {

    @FXML
    private JFXTextField memberId;
    @FXML
    private JFXTextField bookIsdn;
    @FXML
    private JFXButton checkOutButton;
    @FXML
    private TableView<CheckoutEntry> tableView;

    ObservableList  observableList = FXCollections.observableArrayList();

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
                bookCopy.setAvailable(false);
                ApplicationInitialDB.saveAllLibraryMembers();
                ApplicationInitialDB.saveAllBooks();
                LibraryUtil.createNewAlert("Checked Out Successfully",
                        "Book Copy id :" + bookCopy.getCopyId() + "\n checked out to  " + selectedLibraryMember.getFirstName() + "  " + selectedLibraryMember.getLastName());
                updateCheckOutRecordObservableList(selectedLibraryMember.getCheckOutRecord().getCheckOutEntries());

            } else {
                LibraryUtil.createNewAlert("No Available Copies !", "Sorry There is no available copies for this Book, please choose another book");
            }

        }

    }

    private void updateCheckOutRecordObservableList(List<CheckoutEntry> checkoutEntries){
        List<String> stringList = new ArrayList<>();
        stringList.add("Ahmed");
        stringList.add("Ahmed");
        stringList.add("Ahmed");
        stringList.add("Ahmed");
        observableList.addAll(stringList);
        tableView.setItems(observableList);

    }
}
