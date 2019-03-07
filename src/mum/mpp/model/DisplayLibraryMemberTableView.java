package mum.mpp.model;

import javafx.beans.property.SimpleStringProperty;

public class DisplayLibraryMemberTableView {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty memberId;
    private SimpleStringProperty address;
    private SimpleStringProperty phoneNumber;

    public DisplayLibraryMemberTableView(String firstName, String  lastName) {
        this.firstName =new SimpleStringProperty( firstName);
        this.lastName = new SimpleStringProperty (lastName);
    }

    public DisplayLibraryMemberTableView(String firstName, String lastName, String memberId, String address, String phoneNumber) {
        this.firstName =new SimpleStringProperty( firstName);
        this.lastName = new SimpleStringProperty (lastName);
        this.memberId = new SimpleStringProperty (memberId);
        this.address = new SimpleStringProperty (address);
        this.phoneNumber = new SimpleStringProperty (phoneNumber);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getMemberId() {
        return memberId.get();
    }

    public SimpleStringProperty memberIdProperty() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId.set(memberId);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }
}
