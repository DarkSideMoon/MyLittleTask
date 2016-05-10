package com.greenowl.model;

import javax.persistence.*;

/**
 * Created by acube on 20.04.2016.
 // Using request scope
 */
@Entity
@Table(name="user")
@NamedQuery(name = "user.getAll", query = "SELECT w from User w")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long Id;

    @Column(name = "name")
    public String name;

    @Column(name = "password")
    public String password;

    @Column(name = "email")
    public String email;

    @Column(name = "gmailauth")
    public boolean isGmailAuth;

    @OneToOne(optional = false)
    @JoinColumn(name="gmailuser", unique = true, nullable = false, updatable = false)
    public GmailUser gmailUser;

    //Constructors
    public User() {}

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
