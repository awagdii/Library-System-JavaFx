package mum.mpp.model;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {
	
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;
	private CheckoutRecord checkoutRecord;


	CheckoutEntry(LocalDate checkOutDate,LocalDate dueDate,BookCopy bookCopy,CheckoutRecord checkOutRecod){
		this.bookCopy=bookCopy;
		this.checkoutDate=checkOutDate;
		this.checkoutRecord=checkOutRecod;
		this.dueDate=dueDate;
		System.out.println("CHECK OUT DATE = "+checkOutDate);
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
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
}
