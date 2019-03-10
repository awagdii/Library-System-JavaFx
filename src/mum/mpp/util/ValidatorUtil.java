package mum.mpp.util;

import mum.mpp.dao.ApplicationInitialDB;
import mum.mpp.dao.IPersonDAO;
import mum.mpp.dao.PersonDAO;
import mum.mpp.model.Book;
import mum.mpp.model.LibraryMember;

public class ValidatorUtil {

   static IPersonDAO personDAO=new PersonDAO();

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static boolean isNotUniqueISBN(String isbn){
        for (Book book : personDAO.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }


    public static boolean isNotMemberIdUnique(String idMember){
        for (LibraryMember lm:personDAO.getLibraryMembers()) {
            if (lm.getMemberId().equals(idMember)) {
                return true;
            }
        }
        return false;
    }
}
