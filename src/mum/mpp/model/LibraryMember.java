package mum.mpp.model;

import java.io.Serializable;
import java.util.List;

public class LibraryMember extends Person implements Serializable {
	private String memberID;
	private String password;

	private LibraryMemberAuthorization authorization;
	private List<CheckoutEntry> checkoutRecord;

	public LibraryMember() {
	}

	public LibraryMember(String firstName, String lastName, String phoneNumber, Address address) {
		super(firstName, lastName, phoneNumber, address);
	}

	public LibraryMember(String firstName, String lastName, String phoneNumber, Address address, String memberID, String password, LibraryMemberAuthorization authorization) {
		super(firstName, lastName, phoneNumber, address);
		this.memberID = memberID;
		this.password = password;
		this.authorization = authorization;
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

	public LibraryMemberAuthorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(LibraryMemberAuthorization authorization) {
		this.authorization = authorization;
	}

	public List<CheckoutEntry> getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(List<CheckoutEntry> checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
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
				", authorization=" + authorization +
				", checkoutRecord=" + checkoutRecord +
				'}';
	}
}