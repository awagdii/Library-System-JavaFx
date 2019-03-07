package mum.mpp.model;

import javafx.beans.property.SimpleStringProperty;

public class CheckOutEntryTableView {

    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty bookTitle;
    private SimpleStringProperty bookIsbn;
    private SimpleStringProperty borrowDate;
    private SimpleStringProperty dueDate;
    private SimpleStringProperty copyId;

    public CheckOutEntryTableView(String firstname, String lastname, String bookTitle, String bookIsbn, String borrowDate, String dueDate, String copyId) {
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.bookTitle = new SimpleStringProperty(bookTitle);
        this.bookIsbn = new SimpleStringProperty(bookIsbn);
        this.borrowDate = new SimpleStringProperty(borrowDate);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.copyId = new SimpleStringProperty(copyId);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getBookTitle() {
        return bookTitle.get();
    }

    public SimpleStringProperty bookTitleProperty() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle.set(bookTitle);
    }

    public String getBookIsbn() {
        return bookIsbn.get();
    }

    public SimpleStringProperty bookIsbnProperty() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn.set(bookIsbn);
    }

    public String getBorrowDate() {
        return borrowDate.get();
    }

    public SimpleStringProperty borrowDateProperty() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate.set(borrowDate);
    }

    public String getDueDate() {
        return dueDate.get();
    }

    public SimpleStringProperty dueDateProperty() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate.set(dueDate);
    }

    public String getCopyId() {
        return copyId.get();
    }

    public SimpleStringProperty copyIdProperty() {
        return copyId;
    }

    public void setCopyId(String copyId) {
        this.copyId.set(copyId);
    }
}
