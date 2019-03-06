package mum.mpp.model;

import java.io.Serializable;

public class Librarian implements  Authorizable, Serializable {

    private String username;
    private String password;

    public Librarian() {
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public LibraryMemberAuthorization getAuthorization() {
        return LibraryMemberAuthorization.LIBRARIAN;
    }

}
