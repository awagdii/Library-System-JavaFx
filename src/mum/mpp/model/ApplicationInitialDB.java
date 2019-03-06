package mum.mpp.model;

import mum.mpp.util.IConstants;
import mum.mpp.util.LibraryUtil;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplicationInitialDB {

    private ApplicationInitialDB() {
        // TODO Auto-generated constructor stub
    }

    public static List<LibraryMember> librarians = new ArrayList<>();
    public static List<SuperAdministrator> superAdministrators = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<Administrator> administrators = new ArrayList<>();

    public static ApplicationInitialDB loadInitialDB() {
        File file = new File(IConstants.SERIALIZATION_ROOT_FOLDER);
        File[] dataFiles = file.listFiles();
        ApplicationInitialDB aid = new ApplicationInitialDB();
        for (File tempF : dataFiles) {
            if (tempF.getName().equals(IConstants.SERIALIZATION_BOOK_FILENAME)) {
                books = LibraryUtil.readSerializedObject(tempF.getName());
            } else if (tempF.getName().equals(IConstants.SERIALIZATION_LIB_MEMBER_FILENAME)) {
                librarians = LibraryUtil.readSerializedObject(tempF.getName());
            } else if ((tempF.getName().equals(IConstants.SERIALIZATION_SUPER_ADMIN_FILENAME))) {
                superAdministrators = LibraryUtil.readSerializedObject(tempF.getName());
            } else if ((tempF.getName().equals(IConstants.SERIALIZATION_ADMIN_FILENAME))) {
                administrators = LibraryUtil.readSerializedObject(tempF.getName());
            }

        }

        return aid;
    }

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
        address1.setCity("Newyork");
        address1.setState("Taxes");
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
        author.setBio("12 book");
        author.setCredentials("Iam Credentials");
        author.setFirstName("author first name");
        author.setLastName("author last name");
        author.setPhoneNumber("+1(641)-67212111");
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book1 = new Book("0","Secret Of Life","213",3,21,authors);
        BookCopy bookcopy1 = new BookCopy("1",book1);
        bookcopy1.setCopyId("12_11");
        BookCopy bookcopy2 =new BookCopy("2",book1);
        bookcopy2.setCopyId("12_101");
        BookCopy bookcopy3 =new BookCopy("3",book1);
        bookcopy3.setCopyId("12_141");
        BookCopy bookcopy4 = new BookCopy("4",book1);
        bookcopy4.setCopyId("12_19");
        List<BookCopy> bookcopies = book1.getCopyList();
        bookcopies.add(bookcopy1);
        bookcopies.add(bookcopy2);
        bookcopies.add(bookcopy3);
        bookcopies.add(bookcopy4);
        book1.setCopyList(bookcopies);



        Author author2 = new Author();
        author2.setAddress(address1);
        author2.setBio("19 book");
        author2.setCredentials("Iam Credentials");
        author2.setFirstName("author2 first name");
        author2.setLastName("author2 last name");
        author2.setPhoneNumber("+1(641)-672000111");
        ArrayList<Author> authors2 = new ArrayList<>();
        authors2.add(author2);
        Book book2 = new Book("0","Java technology","210",30,21,authors2);
        BookCopy bookcopy5 = new BookCopy("1",book2);
        BookCopy bookcopy6 =new BookCopy("2",book2);
        BookCopy bookcopy7 =new BookCopy("3",book2);
        BookCopy bookcopy8 = new BookCopy("4",book2);
        List<BookCopy> bookcopies2 = book2.getCopyList();
        bookcopies.add(bookcopy4);
        bookcopies.add(bookcopy5);
        bookcopies.add(bookcopy6);
        bookcopies.add(bookcopy7);
        book1.setCopyList(bookcopies2);


        Author author3 = new Author();
        author3.setAddress(address1);
        author3.setBio("10 book");
        author3.setCredentials("Iam Credentials");
        author3.setFirstName("author first name");
        author3.setLastName("author last name");
        author3.setPhoneNumber("+1(641)-672199999");
        ArrayList<Author> authors3 = new ArrayList<>();
        authors3.add(author3);
        Book book3 = new Book("0","TM Techniques","299",90,7,authors);
        BookCopy bookcopy13 = new BookCopy("1",book3);
        BookCopy bookcopy23 =new BookCopy("2",book3);
        List<BookCopy> bookcopies3 = book1.getCopyList();
        bookcopies3.add(bookcopy13);
        bookcopies3.add(bookcopy23);
        book3.setCopyList(bookcopies3);



        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        LibraryUtil.writeSerializedObject(books, IConstants.SERIALIZATION_BOOK_FILENAME);


        LibraryMember libM1 = new LibraryMember();
        libM1.setFirstName("Kai");
        libM1.setLastName("Wang");
        libM1.setMemberId("123");
        libM1.setPhoneNumber("+1(641)-9712212");
        libM1.setAddress(address1);


        CheckoutRecord record1 = new CheckoutRecord(LocalDate.of(2019, Month.FEBRUARY, 1),LocalDate.of(2019, Month.FEBRUARY, 22),book1,libM1);
        record1.getCheckOutEntries().add(new CheckoutEntry (LocalDate.of(2019, 3, 1),
                                                            LocalDate.of(2019, 3, 8),bookcopy1,record1));

        record1.getCheckOutEntries().add(new CheckoutEntry (LocalDate.of(2019, 3, 8),
                LocalDate.of(2019, 3, 15),bookcopy2,record1));

        libM1.setCheckOutRecord(record1);


        LibraryMember libM2 = new LibraryMember();
        libM2.setFirstName("Wagdi");
        libM2.setLastName("Zakzok");
        libM2.setPhoneNumber("+1(641)-9712212");
        libM2.setAddress(address1);


        LibraryMember libM3 = new LibraryMember();
        libM3.setFirstName("Hesham");
        libM3.setLastName("Mahmoud");
        libM3.setPhoneNumber("+1(641)-9712212");
        libM3.setAddress(address1);


        ArrayList<LibraryMember> libMems = new ArrayList<>();

        Collections.addAll(libMems, libM1, libM2, libM3);
        LibraryUtil.writeSerializedObject(libMems, IConstants.SERIALIZATION_LIB_MEMBER_FILENAME);
    }
}
