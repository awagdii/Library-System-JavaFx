package mum.mpp.business;

import mum.mpp.dao.IPersonDAO;
import mum.mpp.dao.PersonDAO;
import mum.mpp.model.*;
import mum.mpp.dao.ApplicationInitialDB;
import mum.mpp.util.IConstants;
import mum.mpp.util.transferobj.PersonActionResult;

import java.util.ArrayList;
import java.util.List;

public class ServicesImp implements IServices {


    private ServicesImp(){

    }

    private static ServicesImp servicesImp=new ServicesImp();

    public static ServicesImp getServicesImp(){
        return servicesImp;
    }

    IPersonDAO personDAO=new PersonDAO();

    @Override
    public Authorizable login(String username, String password) {
        for (SuperAdministrator superAdministrator : personDAO.getSuperAdmin()) {
            if (superAdministrator.getUsername() != null && superAdministrator.getUsername().equals(username)) {
                return superAdministrator;
            }
        }
        for (Administrator administrator : personDAO.getAdmins()) {
            if (administrator.getUsername() != null && administrator.getUsername().equals(username)) {
                return administrator;
            }
        }
        for (Librarian librarian : personDAO.getLibrarians()) {
            if (librarian.getUsername() != null && librarian.getUsername().equals(username)) {
                return librarian;
            }
        }

        return null;
    }

    @Override
    public PersonActionResult checkOutBook(Person person) {
        return null;
    }

    @Override
    public PersonActionResult addLibraryMember(LibraryMember libraryMember) {
        //TODO Validation
       personDAO.getLibraryMembers().add(libraryMember);
        ((PersonDAO)personDAO).serliazeList(personDAO.getLibraryMembers(), IConstants.SERIALIZATION_LIB_MEMBER_FILENAME);
        PersonActionResult result = new PersonActionResult();
        result.setResult(true);
        result.setActionMessage("Add Library Member Success");
        return result;
    }

    public List<Author>  getAuthors() {
        return personDAO.getAuthors();
    }

    public List<Book> getBooks(){
        return personDAO.getBooks();
    }


    public List<LibraryMember> getLibraryMembers(){
        return personDAO.getLibraryMembers();
    }

    @Override
    public PersonActionResult updateLibraryMember(LibraryMember libraryMember, LibraryMember oldLibraryMember) {
        return null;
    }

    @Override
    public PersonActionResult addBook(Book book) {
        personDAO.addBook(book);
        return null;
    }

    @Override
    public PersonActionResult addBookCopies(Book book, ArrayList<BookCopy> bookCopies) {
        return null;
    }


    public void loadInitialDB() {
         personDAO.loadInitialDB();
    }

    public void addAuthor(Author a){
      personDAO.getAuthors().add(a);
    }

}
