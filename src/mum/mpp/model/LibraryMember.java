package mum.mpp.model;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {

    private String memberId;

    private CheckoutRecord checkOutRecord;

    public CheckoutRecord getCheckOutRecord() {
        return checkOutRecord;
    }

    public void setCheckOutRecord(CheckoutRecord checkOutRecord) {
        this.checkOutRecord = checkOutRecord;
    }

    public LibraryMember(String memberId) {
        this.memberId = memberId;
        this.checkOutRecord= new CheckoutRecord(this);
    }

    public LibraryMember(String firstName, String lastName, String phoneNumber, Address address) {
        super(firstName, lastName, phoneNumber, address);
        this.checkOutRecord= new CheckoutRecord(this);
    }


    @Override
    public String toString() {
        return "AddLibraryMember{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", address=" + getAddress() + '\'' +
                ", checkoutRecord=" + checkOutRecord.toString() +
                '}';
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}