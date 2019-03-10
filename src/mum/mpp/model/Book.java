package mum.mpp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Book implements Serializable {


    public Book(String copyId, String title, String isbn, int borrowModel, ArrayList<Author> authors) {
        this.authorList = authors;
        this.borrowModel = borrowModel;
        this.isbn = isbn;
        this.title = title;
        addBookCopy(copyId, this);
    }

    private String title;
    private String isbn;

    private int borrowModel = 21;  //this may be 7 or 21 DAYS

    private List<Author> authorList = new ArrayList<>();
    private List<BookCopy> copyList = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<BookCopy> getCopyList() {
        return copyList;
    }


    public void addBookCopy(String copyId,Book book) {
        copyList.add(new BookCopy(copyId, book));
    }

    public BookCopy getAvailableCopy() {
        for (BookCopy bookCopy : copyList) {
            if (bookCopy.isAvailable()) {
                return bookCopy;
            }
        }
        return null;
    }


    public int getBorrowModel() {
        return borrowModel;
    }

    public void setBorrowModel(int borrowModel) {
        this.borrowModel = borrowModel;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", borrowModel=" + borrowModel +
                ", authorList=" + authorList +
                ", copyList=" + copyList +
                '}';
    }
}
