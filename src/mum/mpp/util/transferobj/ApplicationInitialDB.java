package mum.mpp.util.transferobj;

import mum.mpp.model.*;
import mum.mpp.util.IConstants;
import mum.mpp.util.LibraryUtil;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApplicationInitialDB {

    private ApplicationInitialDB() {
        // TODO Auto-generated constructor stub
    }

    public static  List<LibraryMember> librarians = new ArrayList<>();
    public static  List<SuperAdministrator> superAdministrators = new ArrayList<>();
    public static  List<Book> books = new ArrayList<>();
    public static  List<Administrator> administrators = new ArrayList<>();
    
    
    public static ApplicationInitialDB loadInitialDB() {
        File file = new File(IConstants.SERIALIZATION_ROOT_FOLDER);
        File[] dataFiles = file.listFiles();
        ApplicationInitialDB aid = new ApplicationInitialDB();
        for (File tempF : dataFiles) {
            if (tempF.getName().equals(IConstants.SERIALIZATION_BOOK_FILENAME)) {
                books=LibraryUtil.readSerializedObject(tempF.getName());
            } else if (tempF.getName().equals(IConstants.SERIALIZATION_LIB_FILENAME)) {
            	librarians = LibraryUtil.readSerializedObject(tempF.getName());
            } else if ((tempF.getName().equals(IConstants.SERIALIZATION_SUPER_ADMIN_FILENAME))) {
                superAdministrators=LibraryUtil.readSerializedObject(tempF.getName());
            }else if ((tempF.getName().equals(IConstants.SERIALIZATION_ADMIN_FILENAME))) {
                administrators=LibraryUtil.readSerializedObject(tempF.getName());
            }   

        }

        return aid;
    }

    public static void prepareSomeInitialData() {
        
    	
    	//TODO Add new Administrator Objects and Sealize them to the Initial DB
    	//TODO Set User Name Password Per User (Admin - Super Admin - Lib Member)
      
    	
    	//Add Administrator One
        SuperAdministrator admin = new SuperAdministrator();
        admin.setFirstName("Anglo");
        admin.setLastName("Andro");
        admin.setPhoneNumber("+1(641)-76630932");
        Address address = new Address();
        address.setCity("Iowa");
        address.setState("Chicago");
        address.setZip("52557");
        address.setStreet("1000Nth 4th Street");
        admin.setAddress(address);
        
        
        

        //Add Administrator One
        SuperAdministrator admin1 = new SuperAdministrator();
        admin.setFirstName("Kefin");
        admin.setLastName("Mark");
        admin.setPhoneNumber("+1(641)-76600932");
        Address address1 = new Address();
        address1.setCity("Newyork");
        address1.setState("Taxes");
        address1.setZip("129837");
        address1.setStreet("10Nth 8th Street");
        admin1.setAddress(address);
       
        
        ArrayList<SuperAdministrator> admins=new ArrayList<>();
        LibraryUtil.writeSerializedObject(admins, "SuperAdministrators");
        
        
        
        Book book1 = new Book();
        book1.setTitle("Secret Of Life");
        book1.setIsbn("12");
        BookCopy bookcopy1 = new BookCopy();
        bookcopy1.setCopyId("12_11");
        BookCopy bookcopy2 = new BookCopy();
        bookcopy2.setCopyId("12_101");
        BookCopy bookcopy3 = new BookCopy();
        bookcopy3.setCopyId("12_141");
        BookCopy bookcopy4 = new BookCopy();
        bookcopy4.setCopyId("12_19");
        ArrayList<BookCopy> bookcopies = new ArrayList<>();
        bookcopies.add(bookcopy1);
        bookcopies.add(bookcopy2);
        bookcopies.add(bookcopy3);
        bookcopies.add(bookcopy4);
        book1.setCopyList(bookcopies);
        Author author = new Author();
        author.setAddress(address1);
        author.setBio("12 book");
        author.setCredentials("Iam Credentials");
        author.setFirstName("author first name");
        author.setLastName("author last name");
        author.setPhoneNumber("+1(641)-67212111");
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(author);
        book1.setAuthorList(authors);
       
        Book book2 = new Book();
        book1.setTitle("Foot Art");
        book1.setIsbn("20");
        BookCopy boookcopy1 = new BookCopy();
        boookcopy1.setCopyId("_11");
        BookCopy boookcopy2 = new BookCopy();
        boookcopy2.setCopyId("12_101");
        BookCopy boookcopy3 = new BookCopy();
        boookcopy3.setCopyId("12_141");
        BookCopy boookcopy4 = new BookCopy();
        boookcopy4.setCopyId("12_19");
        ArrayList<BookCopy> bookcopies2 = new ArrayList<>();
        bookcopies2.add(boookcopy1);
        bookcopies2.add(boookcopy2);
        bookcopies2.add(boookcopy3);
        bookcopies2.add(boookcopy4);
        book2.setCopyList(bookcopies2);
        Author author2 = new Author();
        author2.setAddress(address1);
        author2.setBio("19 book");
        author2.setCredentials("Iam Credentials");
        author2.setFirstName("author first name");
        author2.setLastName("author last name");
        author2.setPhoneNumber("+1(641)-67212111");
        ArrayList<Author> authors2 = new ArrayList<>();
        authors2.add(author2);
        book2.setAuthorList(authors2);
     
        Book book3 = new Book();
        book3.setTitle("TM Technique");
        book3.setIsbn("27");
        BookCopy booookcopy1 = new BookCopy();
        booookcopy1.setCopyId("_11");
        BookCopy booookcopy2 = new BookCopy();
        booookcopy2.setCopyId("12_101");
        BookCopy booookcopy3 = new BookCopy();
        booookcopy3.setCopyId("12_141");
        BookCopy booookcopy4 = new BookCopy();
        booookcopy4.setCopyId("12_19");
        ArrayList<BookCopy> booookcopies2 = new ArrayList<>();
        booookcopies2.add(booookcopy1);
        booookcopies2.add(booookcopy2);
        booookcopies2.add(booookcopy3);
        booookcopies2.add(booookcopy4);
        book3.setCopyList(booookcopies2);
        Author author3 = new Author();
        author3.setAddress(address1);
        author3.setBio("1 book");
        author3.setCredentials("Iam Credentials");
        author3.setFirstName("author first name");
        author3.setLastName("author last name");
        author3.setPhoneNumber("+1(641)-67212111");
        ArrayList<Author> authors3 = new ArrayList<>();
        authors3.add(author3);
        book3.setAuthorList(authors3);
     
        
        
        ArrayList<Book> books=new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
       
        LibraryUtil.writeSerializedObject(books, "Books.txt");

        
        
        LibraryMember libM1 = new LibraryMember();
        libM1.setFirstName("Kai");
        libM1.setLastName("Wang");
        libM1.setMemberID("213");
        libM1.setPassword("123");
        libM1.setPhoneNumber("+1(641)-9712212");
        libM1.setAddress(address1);


        CheckoutRecord record1 = new CheckoutRecord();
        
        
        CheckoutEntry coe1 = new CheckoutEntry();
        coe1.setBookCopy(bookcopy3);
        coe1.setCheckoutDate(LocalDate.of(2019, 3, 01));
        coe1.setDueDate(LocalDate.of(2019, 3, 15));


        CheckoutEntry coe2 = new CheckoutEntry();
        coe2.setBookCopy(booookcopy2);
        coe2.setCheckoutDate(LocalDate.of(2019, 2, 01));
        coe2.setDueDate(LocalDate.of(2019, 2, 15));

        CheckoutEntry coe3 = new CheckoutEntry();
        coe3.setBookCopy(bookcopy4);
        coe3.setCheckoutDate(LocalDate.of(2019, 1, 01));
        coe3.setDueDate(LocalDate.of(2019, 1, 15));


        ArrayList<CheckoutEntry> checkOutEntries = new ArrayList<>();
        checkOutEntries.add(coe1);
        checkOutEntries.add(coe2);
        checkOutEntries.add(coe3);
        record1.setCheckOutEntries(checkOutEntries);
        
        
        libM1.setCheckOutRecord(record1);

       

        LibraryMember libM2 = new LibraryMember();
        libM2.setFirstName("Wagdi");
        libM2.setLastName("Zakzo2");
        libM2.setMemberID("443");
        libM2.setPassword("123");
        libM2.setPhoneNumber("+1(641)-9712212");
        libM2.setAddress(address1);
        
        
       
        LibraryMember libM3 = new LibraryMember();
        libM3.setFirstName("Hesham");
        libM3.setLastName("Mahmoud");
        libM3.setMemberID("213");
        libM3.setPassword("123");
        libM3.setPhoneNumber("+1(641)-9712212");
        libM3.setAddress(address1);
        
        
        ArrayList<LibraryMember> libMems=new ArrayList<>();
        
        
        LibraryUtil.writeSerializedObject(libMems, "LibMember.txt");
    }
}
