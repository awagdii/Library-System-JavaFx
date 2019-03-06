package mum.mpp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class CheckoutRecord implements Serializable {

private LibraryMember libraryMember;

private ArrayList<CheckoutEntry> checkOutEntries=new ArrayList<>();

public ArrayList<CheckoutEntry> getCheckOutEntries() {
	return checkOutEntries;
}

public void setCheckOutEntries(ArrayList<CheckoutEntry> checkOutEntries) {
	this.checkOutEntries = checkOutEntries;
}

public CheckoutRecord(LocalDate checkOutDate,LocalDate dueDate,Book book,LibraryMember libraryMember){
 	  this.libraryMember=libraryMember;
 	  addCheckOutEntry(checkOutDate,dueDate,book);
}


public void addCheckOutEntry(LocalDate checkOutDate,LocalDate dueDate,Book book){
		checkOutEntries.add(new CheckoutEntry(checkOutDate, dueDate, book, this));
}


	public LibraryMember getLibraryMember() {
		return libraryMember;
	}

	public void setLibraryMember(LibraryMember libraryMember) {
		this.libraryMember = libraryMember;
	}
}
