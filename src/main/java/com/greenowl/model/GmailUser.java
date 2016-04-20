package com.greenowl.model;

/**
 * Created by acube on 20.04.2016.
 */
public class GmailUser {

    public String email;
    public String password;

    public GmailUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
