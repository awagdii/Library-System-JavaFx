package mum.mpp.model;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable, Authorizable {
    private String username;
    private String password;

    private CheckoutRecord checkOutRecord = new CheckoutRecord();

    public CheckoutRecord getCheckOutRecord() {
        return checkOutRecord;
    }

    public void setCheckOutRecord(CheckoutRecord checkOutRecord) {
        this.checkOutRecord = checkOutRecord;
    }

    public LibraryMember() {
    }

    public LibraryMember(String firstName, String lastName, String phoneNumber, Address address) {
        super(firstName, lastName, phoneNumber, address);
    }

    public LibraryMember(String firstName, String lastName, String phoneNumber, Address address, String username, String password, LibraryMemberAuthorization authorization) {
        super(firstName, lastName, phoneNumber, address);
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public LibraryMemberAuthorization getAuthorization() {
        return LibraryMemberAuthorization.LIBRARIAN;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    @Override
    public Address getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(Address address) {
        super.setAddress(address);
    }

    @Override
    public String toString() {
        return "LibraryMember{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", address=" + getAddress() + '\'' +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", checkoutRecord=" + checkOutRecord.toString() +
                '}';
    }
}