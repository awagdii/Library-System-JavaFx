package mum.mpp.model;

import java.util.List;

enum LibraryMemberAuthorization {
	ADMIN,
	LIBRARIAN,
	BOTH
}

public class LibraryMember extends Person {
	private String memberID;
	private String password;
	private LibraryMemberAuthorization authorization;
	private List<CheckoutEntity> checkoutRecord;
}