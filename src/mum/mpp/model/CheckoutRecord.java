package mum.mpp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

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

	@Override
	public String toString() {
		String string = "";
		StringBuilder builder = new StringBuilder();
		Formatter formatter = new Formatter(builder, Locale.US);
		string += formatter.format("%-6s | %-10s | %-10s | %-10s | %-10s %n", "Member ID", "First Name", "Last Name", "Check Date", "Due Date").toString();
		String memID = libraryMember.getMemberId();
		String firstName = libraryMember.getFirstName();
		String lastName = libraryMember.getLastName();

		for (CheckoutEntry entry: checkOutEntries) {
			string += formatter.format("%-9s | %-10s | %-10s | %-10tD | %-10tD %n", memID, firstName, lastName, entry.getCheckoutDate(), entry.getDueDate());
		}
		return string;
	}
}
