package mum.mpp.business;

import mum.mpp.model.Book;
import mum.mpp.util.transferobj.PersonActionResult;

import java.util.ArrayList;

import mum.mpp.model.*;

public interface IServices {

	
public  Authorizable login(String username,String password);

public PersonActionResult checkOutBook(Person person); 

public PersonActionResult addLibraryMember(LibraryMember libraryMember);

public PersonActionResult updateLibraryMember(LibraryMember libraryMember, LibraryMember oldLibraryMember);

public PersonActionResult addBook(Book book);

public PersonActionResult addBookCopies(Book book, ArrayList<BookCopy> bookCopies);

public PersonActionResult signOut(Person person);
}

