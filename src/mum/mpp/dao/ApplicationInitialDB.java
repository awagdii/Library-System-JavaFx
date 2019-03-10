package mum.mpp.dao;

import mum.mpp.model.*;
import mum.mpp.util.IConstants;
import mum.mpp.util.LibraryUtil;

import java.io.File;
import java.util.*;

public class ApplicationInitialDB {

    private ApplicationInitialDB() {
        // TODO Auto-generated constructor stub
    }

     private static List<Librarian> librarians = new ArrayList<>();
     private static List<LibraryMember> libraryMembers = new ArrayList<>();
     private static List<SuperAdministrator> superAdministrators = new ArrayList<>();
     private static List<Book> books = new ArrayList<>();
     private static List<Administrator> administrators = new ArrayList<>();
     private static List<Author> authors = new ArrayList<>();

     public static void loadInitialDB(){
         DBUtil.loadInitialDB();
     }

     public static void saveAllBooks() {
        LibraryUtil.writeSerializedObject(ApplicationInitialDB.getBooks(), IConstants.SERIALIZATION_BOOK_FILENAME);
    }

    public static void saveAllLibraryMembers() {
        LibraryUtil.writeSerializedObject(ApplicationInitialDB.getLibraryMembers(), IConstants.SERIALIZATION_LIB_MEMBER_FILENAME);
    }




    public static void main(String[] args){
          setLibraryMembers(LibraryUtil.readSerializedObject(IConstants.SERIALIZATION_LIB_MEMBER_FILENAME));
          for(LibraryMember l: getLibraryMembers()){
              System.out.println(l.getMemberId() +" > " +l.getFirstName()+ "  > "+l.getLastName());
          }
    }

     static List<Librarian> getLibrarians() {
        return librarians;
    }

     static void setLibrarians(List<Librarian> librarians) {
        ApplicationInitialDB.librarians = librarians;
    }

     static List<LibraryMember> getLibraryMembers() {
        return libraryMembers;
    }

     static void setLibraryMembers(List<LibraryMember> libraryMembers) {
        ApplicationInitialDB.libraryMembers = libraryMembers;
    }

     static List<SuperAdministrator> getSuperAdministrators() {
        return superAdministrators;
    }

     static void setSuperAdministrators(List<SuperAdministrator> superAdministrators) {
        ApplicationInitialDB.superAdministrators = superAdministrators;
    }

     static List<Book> getBooks() {
        return books;
    }

     static void setBooks(List<Book> books) {
        ApplicationInitialDB.books = books;
    }

     static List<Administrator> getAdministrators() {
        return administrators;
    }

     static void setAdministrators(List<Administrator> administrators) {
        ApplicationInitialDB.administrators = administrators;
    }

     static List<Author> getAuthors() {
        return authors;
    }

     static void setAuthors(List<Author> authors) {
        ApplicationInitialDB.authors = authors;
    }

}
