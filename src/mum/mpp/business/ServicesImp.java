package mum.mpp.business;

import javafx.scene.control.Alert;
import mum.mpp.dao.IPersonDAO;
import mum.mpp.dao.PersonDAO;
import mum.mpp.model.*;
import mum.mpp.model.ApplicationInitialDB;
import mum.mpp.util.IConstants;
import mum.mpp.util.transferobj.PersonActionResult;

import java.util.ArrayList;

public class ServicesImp implements IServices {


    IPersonDAO personDAO=new PersonDAO();

    @Override
    public Authorizable login(String username, String password) {
        for (SuperAdministrator superAdministrator : ApplicationInitialDB.superAdministrators) {
            if (superAdministrator.getUsername() != null && superAdministrator.getUsername().equals(username)) {
                return superAdministrator;
            }
        }
        for (Administrator administrator : ApplicationInitialDB.administrators) {
            if (administrator.getUsername() != null && administrator.getUsername().equals(username)) {
                return administrator;
            }
        }
        for (Librarian librarian : ApplicationInitialDB.librarians) {
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
        ApplicationInitialDB.libraryMembers.add(libraryMember);
        ((PersonDAO)personDAO).serliazeList(ApplicationInitialDB.libraryMembers, IConstants.SERIALIZATION_LIB_MEMBER_FILENAME);
        PersonActionResult result = new PersonActionResult();
        result.setResult(true);
        result.setActionMessage("Add Library Member Success");

        return result;
    }

    @Override
    public PersonActionResult updateLibraryMember(LibraryMember libraryMember, LibraryMember oldLibraryMember) {
        return null;
    }

    @Override
    public PersonActionResult addBook(Book book) {
        return null;
    }

    @Override
    public PersonActionResult addBookCopies(Book book, ArrayList<BookCopy> bookCopies) {
        return null;
    }

    @Override
    public PersonActionResult signOut(Person person) {
        return null;
    }
}
