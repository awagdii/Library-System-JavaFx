package mum.mpp.dao;

import java.util.ArrayList;

import mum.mpp.model.Book;
import mum.mpp.model.BookCopy;
import mum.mpp.model.CheckoutRecord;
import mum.mpp.model.Person;
import mum.mpp.util.transferobj.ApplicationInitialDB;

public class PersonDAO implements IPersonDAO {

	private ApplicationInitialDB appInitalDB;
	public PersonDAO() {
		//You can Use this Object for read any data you want
		appInitalDB=ApplicationInitialDB.loadIntialDB();	
	}
	
	@Override
	public ArrayList<Person> loadPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	public ApplicationInitialDB getAppInitalDB() {
		return appInitalDB;
	}

	public void setAppInitalDB(ApplicationInitialDB appInitalDB) {
		this.appInitalDB = appInitalDB;
	}

	@Override
	public ArrayList<Book> LoadLiberaryBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BookCopy> LoadBookCopies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckoutRecord LoadCheckOutRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static void main(String[] args) {
		PersonDAO p=new PersonDAO();
		//System.out.println((p.getAppInitalDB().getBooks().size()));
	}
	
}
