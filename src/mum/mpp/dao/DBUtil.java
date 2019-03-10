package mum.mpp.dao;

import mum.mpp.dao.ApplicationInitialDB;
import mum.mpp.model.*;
import mum.mpp.util.IConstants;
import mum.mpp.util.LibraryUtil;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class DBUtil {


    public static void prepareSomeInitialData() {


        //TODO Add new Administrator Objects and Sealize them to the Initial DB
        //TODO Set User Name Password Per User (Admin - Super Admin - Lib Member)


        //Add Administrator One
        Administrator administrator1 = new Administrator();
        administrator1.setUsername("admin");
        administrator1.setPassword("admin");
        List<Administrator> administrators = new ArrayList<>();
        Collections.addAll(administrators, administrator1);
        LibraryUtil.writeSerializedObject(administrators, IConstants.SERIALIZATION_ADMIN_FILENAME);

        Address address = new Address();
        address.setCity("Iowa");
        address.setState("Chicago");
        address.setZip("52557");
        address.setStreet("1000Nth 4th Street");


        Address address1 = new Address();
        address1.setCity("NewYork");
        address1.setState("California");
        address1.setZip("129837");
        address1.setStreet("10Nth 8th Street");


        //Add Super Admin
        SuperAdministrator superAdministrator1 = new SuperAdministrator();
        superAdministrator1.setUsername("superadmin");
        superAdministrator1.setPassword("superadmin");

        ArrayList<SuperAdministrator> admins = new ArrayList<>();
        Collections.addAll(admins, superAdministrator1);
        LibraryUtil.writeSerializedObject(admins, IConstants.SERIALIZATION_SUPER_ADMIN_FILENAME);


        Author author = new Author();
        author.setAddress(address1);
        author.setBio("Chinese Writer has 12 books");
        author.setCredentials("Cerdentials");
        author.setFirstName("Ken");
        author.setLastName("Wang");
        author.setPhoneNumber("+1(641)-67212111");
        ArrayList<Author> authors = new ArrayList<>();


        Author author11 = new Author();
        author11.setAddress(address1);
        author11.setBio("14 book");
        author11.setCredentials("Iam Credentials");
        author11.setFirstName("Frenchez");
        author11.setLastName("Micheal");
        author11.setPhoneNumber("+1(641)-67212111");



        authors.add(author11);



        Author author14 = new Author();
        author14.setAddress(address1);
        author14.setBio("17 book");
        author14.setCredentials("Iam Credentials");
        author14.setFirstName("Mariem");
        author14.setLastName("Mortada");
        author14.setPhoneNumber("+1(641)-67212111");



        authors.add(author14);



        Book book1 = new Book(UUID.randomUUID().toString(), "Secret Of Life", "1111", 3, authors);
        book1.addBookCopy(UUID.randomUUID().toString(), book1);
        book1.addBookCopy(UUID.randomUUID().toString(), book1);
        book1.addBookCopy(UUID.randomUUID().toString(), book1);
        book1.addBookCopy(UUID.randomUUID().toString(), book1);

        Author author2 = new Author();
        author2.setAddress(address1);
        author2.setBio("19 book");
        author2.setCredentials("Iam Credentials");
        author2.setFirstName("kefin");
        author2.setLastName("don");
        author2.setPhoneNumber("+1(641)-672000111");
        ArrayList<Author> authors2 = new ArrayList<>();
        authors2.add(author2);
        Book book2 = new Book(UUID.randomUUID().toString(), "Java technology", "2222", 30, authors2);
        book2.addBookCopy(UUID.randomUUID().toString(), book2);
        book2.addBookCopy(UUID.randomUUID().toString(), book2);
        book2.addBookCopy(UUID.randomUUID().toString(), book2);
        book2.addBookCopy(UUID.randomUUID().toString(), book2);


        Author author3 = new Author();
        author3.setAddress(address1);
        author3.setBio("10 book");
        author3.setCredentials("Iam Credentials");
        author3.setFirstName("hernandiz");
        author3.setLastName("kamal");
        author3.setPhoneNumber("+1(641)-672199999");
        ArrayList<Author> authors3 = new ArrayList<>();
        authors3.add(author3);
        Book book3 = new Book(UUID.randomUUID().toString(), "TM Techniques", "3333", 90, authors);
        book3.addBookCopy(UUID.randomUUID().toString(), book3);
        book3.addBookCopy(UUID.randomUUID().toString(), book3);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        LibraryUtil.writeSerializedObject(books, IConstants.SERIALIZATION_BOOK_FILENAME);


        LibraryMember libM1 = new LibraryMember("1");
        libM1.setFirstName("Kai");
        libM1.setLastName("Wang");
        libM1.setPhoneNumber("+1(641)-9712212");
        libM1.setAddress(address1);


        LibraryMember libM2 = new LibraryMember("2");
        libM2.setFirstName("Wagdi");
        libM2.setLastName("Zakzok");
        libM2.setPhoneNumber("+1(641)-9712212");
        libM2.setAddress(address1);


        LibraryMember libM3 = new LibraryMember("3");
        libM3.setFirstName("Hesham");
        libM3.setLastName("Mahmoud");
        libM3.setPhoneNumber("+1(641)-9712212");
        libM3.setAddress(address1);


        ArrayList<LibraryMember> libMems = new ArrayList<>();

        Collections.addAll(libMems, libM1, libM2, libM3);
        LibraryUtil.writeSerializedObject(libMems, IConstants.SERIALIZATION_LIB_MEMBER_FILENAME);

        Librarian l1 = new Librarian();
        l1.setPassword("librarian");
        l1.setUsername("librarian");


        ArrayList<Librarian> librarians = new ArrayList<>();

        librarians.add(l1);
        LibraryUtil.writeSerializedObject(librarians, IConstants.SERIALIZATION_LIBRIRIAN_FILENAME);

        System.out.println(book2);


        authors.add(author2);
        authors.add(author3);

        LibraryUtil.writeSerializedObject(authors, IConstants.SERIALIZATION_AUTHORS_FILENAME);


    }
    public static void loadInitialDB() {
        File file = new File(IConstants.SERIALIZATION_ROOT_FOLDER);
        File[] dataFiles = file.listFiles();
        for (File tempF : dataFiles) {
            if (tempF.getName().equals(IConstants.SERIALIZATION_BOOK_FILENAME)) {
                ApplicationInitialDB.setBooks(LibraryUtil.readSerializedObject(tempF.getName()));
            } else if (tempF.getName().equals(IConstants.SERIALIZATION_LIB_MEMBER_FILENAME)) {
                ApplicationInitialDB.setLibraryMembers(LibraryUtil.readSerializedObject(tempF.getName()));
            } else if ((tempF.getName().equals(IConstants.SERIALIZATION_SUPER_ADMIN_FILENAME))) {
                ApplicationInitialDB.setSuperAdministrators(LibraryUtil.readSerializedObject(tempF.getName()));
            } else if ((tempF.getName().equals(IConstants.SERIALIZATION_ADMIN_FILENAME))) {
                ApplicationInitialDB.setAdministrators(LibraryUtil.readSerializedObject(tempF.getName()));
            } else if ((tempF.getName().equals(IConstants.SERIALIZATION_LIBRIRIAN_FILENAME))) {
                ApplicationInitialDB.setLibrarians(LibraryUtil.readSerializedObject(tempF.getName()));
            }else if ((tempF.getName().equals(IConstants.SERIALIZATION_AUTHORS_FILENAME))) {
                ApplicationInitialDB.setAuthors(LibraryUtil.readSerializedObject(tempF.getName()));
            }

        }
    }

}
