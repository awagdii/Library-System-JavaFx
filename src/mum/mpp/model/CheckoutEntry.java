package mum.mpp.model;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {
	
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private Book book;
	private CheckoutRecord checkoutRecord;


	CheckoutEntry(LocalDate checkOutDate,LocalDate dueDate,Book book,CheckoutRecord checkOutRecod){
		this.book=book;
		this.checkoutRecord=checkOutRecod;
		this.dueDate=dueDate;
		this.setCheckoutRecord(checkOutRecod);
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book bookCopy) {
		this.book = book;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
}
