package mum.mpp.dao;

import java.util.ArrayList;

import mum.mpp.model.*;

public interface IPersonDAO {

	
	
public ArrayList<Person> loadPersons();

public ArrayList<Book> loadLibraryBooks();

public ArrayList<BookCopy> loadBookCopies();

public CheckoutRecord loadCheckOutRecord();


}
