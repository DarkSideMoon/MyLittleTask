package com.greenowl.model;

import javax.persistence.*;

/**
 * Created by acube on 20.04.2016.
 // Using request scope
 // SQL FRO Create SEQUENCE
 CREATE SEQUENCE public.hibernate_sequence
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
 ALTER TABLE public.hibernate_sequence
 OWNER TO postgres;


 */
@Entity
@Table(name="appuser")
@NamedQuery(name = "appuser.getAll", query = "SELECT w.id from User w")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq_gen")
    @SequenceGenerator(name = "UserID_seq", sequenceName = "user_id_seq")
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

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="gmailuser", nullable = true)
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
