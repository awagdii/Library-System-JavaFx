package mum.mpp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mum.mpp.model.*;
import mum.mpp.util.CheckOutEntryTableView;
import mum.mpp.util.LibraryUtil;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CheckOutBook implements Initializable {

    @FXML
    private JFXTextField memberId;
    @FXML
    private JFXTextField bookIsdn;
    @FXML
    private JFXButton checkOutButton;
    @FXML
    private TableView<CheckOutEntryTableView> tbData;
    @FXML
    private TableColumn<CheckOutEntryTableView, String> firstname;
    @FXML
    private TableColumn<CheckOutEntryTableView, String> lastname;
    @FXML
    private TableColumn<CheckOutEntryTableView, String> bookTitle;
    @FXML
    private TableColumn<CheckOutEntryTableView, String> bookIsbn;
    @FXML
    private TableColumn<CheckOutEntryTableView, String> borrowDate;
    @FXML
    private TableColumn<CheckOutEntryTableView, String> dueDate;
    @FXML
    private TableColumn<CheckOutEntryTableView, String> copyId;


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
                selectedLibraryMember.getCheckOutRecord().addCheckOutEntry(now, dueDate, bookCopy);
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

    private void updateCheckOutRecordObservableList(List<CheckoutEntry> checkoutEntries) {
        List<CheckOutEntryTableView> checkOutEntryTableViews = new ArrayList<>();
        observableList.clear();
        for (CheckoutEntry checkoutEntry : checkoutEntries) {
            String firstname = checkoutEntry.getCheckoutRecord().getLibraryMember().getFirstName();
            String lastname = checkoutEntry.getCheckoutRecord().getLibraryMember().getLastName();
            String bookTitle = checkoutEntry.getBookCopy().getBook().getTitle();
            String bookIsbn = checkoutEntry.getBookCopy().getBook().getIsbn();
            String borrowDate = checkoutEntry.getCheckoutDate().toString();
            String dueDate = checkoutEntry.getDueDate().toString();
            String copyId = checkoutEntry.getBookCopy().getCopyId();

            checkOutEntryTableViews.add(new CheckOutEntryTableView(firstname, lastname, bookTitle, bookIsbn, borrowDate, dueDate, copyId));
        }
        observableList.addAll(checkOutEntryTableViews);
        tbData.setItems(observableList);

    }

    // add your data here from any source
    private ObservableList<CheckOutEntryTableView> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstname.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        bookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        bookIsbn.setCellValueFactory(new PropertyValueFactory<>("bookIsbn"));
        borrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        copyId.setCellValueFactory(new PropertyValueFactory<>("copyId"));
        tbData.setItems(observableList);
    }


}
