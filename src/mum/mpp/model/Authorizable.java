package mum.mpp.model;

public interface Authorizable {

    void setUsername(String username);

    String getUsername();

    void setPassword(String password);

    String getPassword();

    LibraryMemberAuthorization getAuthorization();
}
