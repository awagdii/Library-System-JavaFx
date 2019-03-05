package mum.mpp.business;

import mum.mpp.model.*;
import mum.mpp.util.transferobj.ApplicationInitialDB;
import mum.mpp.util.transferobj.PersonActionResult;

import java.util.ArrayList;

public class ServicesImp implements IServices {


    @Override
    public Authorizable login(String username, String password) {
        System.out.println(ApplicationInitialDB.librarians);
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
        for (LibraryMember libraryMember : ApplicationInitialDB.librarians) {
            if (libraryMember.getUsername() != null && libraryMember.getUsername().equals(username)) {
                return libraryMember;
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
        return null;
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
