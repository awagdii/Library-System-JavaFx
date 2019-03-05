package mum.mpp.model;

import java.io.Serializable;

public class Author extends Person implements Serializable {
	private String credentials;
	private String bio;
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
	
}
