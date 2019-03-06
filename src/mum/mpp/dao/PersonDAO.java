package mum.mpp.dao;

import mum.mpp.model.*;
import mum.mpp.model.ApplicationInitialDB;

import java.util.ArrayList;

public class PersonDAO implements IPersonDAO {


    public PersonDAO() {
        //You can Use this Object for read any data you want
    }

    @Override
    public ArrayList<Person> loadPersons() {
        return null;
    }

    @Override
    public ArrayList<Book> loadLibraryBooks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<BookCopy> loadBookCopies() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CheckoutRecord loadCheckOutRecord() {
        // TODO Auto-generated method stub
        return null;
    }
}
