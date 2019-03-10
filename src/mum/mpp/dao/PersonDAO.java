package mum.mpp.dao;

import mum.mpp.business.ServicesImp;
import mum.mpp.model.*;
import mum.mpp.util.LibraryUtil;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements IPersonDAO {
    public PersonDAO() {
    }
    public <T> void serliazeList(List<T> objs, String listName){
        LibraryUtil.writeSerializedObject(objs,listName);
    }

    public List<SuperAdministrator> getSuperAdmin(){
        return ApplicationInitialDB.getSuperAdministrators();
    }


    public List<Administrator> getAdmins(){
        return ApplicationInitialDB.getAdministrators();
    }

    public List<Librarian> getLibrarians(){
        return ApplicationInitialDB.getLibrarians();
    }

    public List<LibraryMember> getLibraryMembers(){
        return ApplicationInitialDB.getLibraryMembers();
    }

    public List<Author> getAuthors(){
        return ApplicationInitialDB.getAuthors();
    }

    public void addBook(Book book){
        ApplicationInitialDB.getBooks().add(book);
    }

    public List<Book> getBooks(){
        return ApplicationInitialDB.getBooks();
    }
    public void saveAllBooks(){
        ApplicationInitialDB.saveAllBooks();
    }

    @Override
    public void loadInitialDB() {
        ApplicationInitialDB.loadInitialDB();
        if (ApplicationInitialDB.getBooks() != null && ApplicationInitialDB.getBooks().isEmpty()) {
            DBUtil.prepareSomeInitialData();
            ApplicationInitialDB.loadInitialDB();
        }

    }
}
