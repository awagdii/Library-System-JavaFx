package mum.mpp.model;

import java.io.Serializable;
import java.time.LocalDate;

public class BookCopy implements Serializable {
    private String copyId;
    private Book book;
    boolean isAvailable;

    BookCopy(String copyId, Book book) {
        this.book = book;
        this.isAvailable = true;
        this.copyId = copyId;
        book.getCopyList().add(this);
    }

    public String getCopyId() {
        return copyId;
    }

    public void setCopyId(String copyId) {
        this.copyId = copyId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;

    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "copyId='" + copyId + '\'' + '}';
    }
}


