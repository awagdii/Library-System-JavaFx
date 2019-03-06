package mum.mpp.model;

import java.io.Serializable;
import java.time.LocalDate;

public class BookCopy implements Serializable {
	private String copyId;
	private Book book;

	BookCopy(String copyId,Book book){
		this.book = book;
		this.copyId=copyId;
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




}


