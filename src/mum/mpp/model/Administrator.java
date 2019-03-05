package mum.mpp.model;

import java.io.Serializable;

public class Administrator extends Person implements Serializable {

	public Administrator() {
		setAuthorizationLevel(MemberAuthorization.ADMIN);
	}
}
