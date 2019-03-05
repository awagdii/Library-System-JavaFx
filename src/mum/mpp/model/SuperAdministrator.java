package mum.mpp.model;

import java.io.Serializable;

public class SuperAdministrator extends LibraryMember implements Serializable {

    public SuperAdministrator() {
        setAuthorization(LibraryMemberAuthorization.BOTH);
    }
}
