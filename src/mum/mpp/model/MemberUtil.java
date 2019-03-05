package mum.mpp.model;

import java.io.*;

public class MemberUtil {
    public static String FILE_PATH = "./member.txt";

    public static void writeMemberToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            Address address = new Address("N 4th Street", "Fairfield", "IA", "52553");
            LibraryMember member = new LibraryMember("Kai", "Wang", "123-456-7890",
                    address, "001", "123456", LibraryMemberAuthorization.ADMIN);
            outputStream.writeObject(member);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readMemberFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            LibraryMember member = (LibraryMember)inputStream.readObject();
            System.out.println(member);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeMemberToFile();
        readMemberFile();
    }
}
