package mum.mpp.model;

import java.io.Serializable;
import java.util.List;

public class LibraryMember extends Person implements Serializable {
	private String memberID;
	private String password;

	
	private CheckoutRecord checkOutRecord=new CheckoutRecord();

	public CheckoutRecord getCheckOutRecord() {
		return checkOutRecord;
	}

	public void setCheckOutRecord(CheckoutRecord checkOutRecord) {
		this.checkOutRecord = checkOutRecord;
	}

	public LibraryMember() {
	setAuthorization(LibraryMemberAuthorization.LIBRARIAN);
	}

	public LibraryMember(String firstName, String lastName, String phoneNumber, Address address) {
		super(firstName, lastName, phoneNumber, address);
	}

	public LibraryMember(String firstName, String lastName, String phoneNumber, Address address, String memberID, String password, LibraryMemberAuthorization authorization) {
		super(firstName, lastName, phoneNumber, address);
		this.memberID = memberID;
		this.password = password;
		setAuthorization(authorization);
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
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
				"memberID='" + memberID + '\'' +
				", password='" + password + '\'' +
				", authorization=" + getAuthorization() +
				", checkoutRecord=" + checkOutRecord.toString() +
				'}';
	}
}