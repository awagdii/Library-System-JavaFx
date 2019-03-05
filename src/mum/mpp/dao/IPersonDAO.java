package mum.mpp.dao;

import java.util.ArrayList;

import mum.mpp.model.*;

public interface IPersonDAO {

	
	
public ArrayList<Person> loadPersons();

public ArrayList<Book> LoadLiberaryBooks();

public ArrayList<BookCopy> LoadBookCopies();

public CheckoutRecord LoadCheckOutRecord();


}
