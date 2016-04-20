package com.greenowl.model;

/**
 * Created by acube on 20.04.2016.
 */
public class User {


    public Long Id;

    public String name;

    public String password;

    public String email;

    public boolean isGmailAuth;

    public GmailUser gmailUser;

    // Getters And Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public boolean isGmailAuth() {
        return isGmailAuth;
    }

    public void setIsGmailAuth(boolean isGmailAuth) {
        this.isGmailAuth = isGmailAuth;
    }

    public GmailUser getGmailUser() {
        return gmailUser;
    }

    public void setGmailUser(GmailUser gmailUser) {
        this.gmailUser = gmailUser;
    }
}
