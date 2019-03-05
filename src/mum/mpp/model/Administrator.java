package mum.mpp.model;

import java.io.Serializable;

public class Administrator extends LibraryMember implements Serializable {

    public Administrator() {
        setAuthorization(LibraryMemberAuthorization.ADMIN);
    }
}
