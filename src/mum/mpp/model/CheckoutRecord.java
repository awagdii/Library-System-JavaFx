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

public CheckoutRecord(LibraryMember libraryMember){
 	  this.libraryMember=libraryMember;
}


public void addCheckOutEntry(LocalDate checkOutDate,LocalDate dueDate,BookCopy bookCopy){
		checkOutEntries.add(new CheckoutEntry(checkOutDate, dueDate, bookCopy, this));
}


	public LibraryMember getLibraryMember() {
		return libraryMember;
	}

	public void setLibraryMember(LibraryMember libraryMember) {
		this.libraryMember = libraryMember;
	}
}
