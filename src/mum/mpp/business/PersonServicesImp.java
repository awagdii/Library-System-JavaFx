package mum.mpp.business;

import java.util.ArrayList;

import mum.mpp.dao.IPersonDAO;
import mum.mpp.dao.PersonDAO;
import mum.mpp.model.Book;
import mum.mpp.model.BookCopy;
import mum.mpp.model.LibraryMember;
import mum.mpp.model.Person;
import mum.mpp.util.transferobj.PersonActionResult;

public class PersonServicesImp implements IPersonServices {


	IPersonDAO personDAO=new PersonDAO();

	public PersonServicesImp(){
		personDAO = new PersonDAO();
	}

	@Override
	public PersonActionResult Login(Person person) {
		PersonActionResult par=new PersonActionResult();
		ArrayList<Person> ps=personDAO.loadPersons();
		for(Person p:ps){
			if(p.getUserName().equals(person.getUserName()) && p.getPassword().equals(person.getPassword())){
				par.setResult(true);
				par.setPerson(person);
			}
		}
		return par;
	}

	@Override
	public PersonActionResult checkOutBook(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult addLibraryMember(LibraryMember libraryMember) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult updateLibraryMember(LibraryMember libraryMember, LibraryMember oldLibraryMember) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult addBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult addBookCopies(Book book, ArrayList<BookCopy> bookCopies) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonActionResult signOut(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
