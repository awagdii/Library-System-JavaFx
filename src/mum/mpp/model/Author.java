package mum.mpp.model;

import java.io.Serializable;

public class Author extends Person implements Serializable {
	private String credentials;
	private String bio;

	public Author(String firstName, String lastName, String phoneNumber, Address address, String credentials, String bio) {
		super(firstName, lastName, phoneNumber, address);
		this.credentials = credentials;
		this.bio = bio;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Author{" +
				"firstName='" + getFirstName() + '\'' +
				", lastName='" + getLastName() + '\'' +
				", phoneNumber='" + getPhoneNumber() + '\'' +
				", address=" + getAddress() + '\'' +
				"credentials='" + credentials + '\'' +
				", bio='" + bio + '\'' +
				'}';
	}
}
