package mum.mpp.business;

import java.util.ArrayList;

import mum.mpp.model.Book;
import mum.mpp.model.BookCopy;
import mum.mpp.model.LibraryMember;
import mum.mpp.model.Person;
import mum.mpp.util.transferobj.PersonActionResult;

public class PersonServicesImp implements IPersonServices {

	@Override
	public PersonActionResult Login(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult checkOutBook(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult AddLibraryMember(LibraryMember libraryMember) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult UpdateLibraryMember(LibraryMember libraryMember, LibraryMember oldLibraryMember) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult AddBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult AddBookCopies(Book book, ArrayList<BookCopy> bookCopies) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult signOut(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
