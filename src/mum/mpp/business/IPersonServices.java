package mum.mpp.business;

import mum.mpp.model.Book;
import mum.mpp.util.transferobj.PersonActionResult;

import java.util.ArrayList;

import mum.mpp.model.*;

public interface IPersonServices {

	
public PersonActionResult Login(Person person);

public PersonActionResult checkOutBook(Person person); 

public PersonActionResult AddLibraryMember(LibraryMember libraryMember);

public PersonActionResult UpdateLibraryMember(LibraryMember libraryMember,LibraryMember oldLibraryMember);

public PersonActionResult AddBook(Book book);

public PersonActionResult AddBookCopies(Book book,ArrayList<BookCopy> bookCopies);

public PersonActionResult signOut(Person person);
}

