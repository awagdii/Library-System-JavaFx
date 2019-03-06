package mum.mpp.model;

import java.io.Serializable;

public class Administrator  implements Serializable, Authorizable {
    private String username;
    private String password;

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
        return LibraryMemberAuthorization.ADMIN;
    }
}
