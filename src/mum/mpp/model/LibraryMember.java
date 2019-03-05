package mum.mpp.model;

import java.io.Serializable;
import java.util.List;


public class LibraryMember extends Person implements Serializable {
	
	
	
	private String memberID;

	private List<CheckoutRecord> checkoutRecord;
	public LibraryMember() {
		setAuthorizationLevel(MemberAuthorization.LIBRARIAN);
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public List<CheckoutRecord> getCheckoutRecord() {
		return checkoutRecord;
	}
	public void setCheckoutRecord(List<CheckoutRecord> checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
}