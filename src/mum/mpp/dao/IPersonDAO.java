package mum.mpp.dao;

import java.util.ArrayList;
import java.util.List;

import mum.mpp.model.*;

public interface IPersonDAO {




    public List<SuperAdministrator> getSuperAdmin();


    public List<Administrator> getAdmins();

    public List<Librarian> getLibrarians();

    public List<LibraryMember> getLibraryMembers();


    public List<Author> getAuthors();

    public void addBook(Book book);

    public List<Book> getBooks();


    public  void saveAllBooks();

    public void loadInitialDB();

}
