package com.greenowl.model;

import javax.persistence.*;

/**
 * Created by acube on 20.04.2016.
 */
@Entity
@Table(name="gmailuser")
@NamedQuery(name = "gmailuser.getAll", query = "SELECT w from GmailUser w")
public class GmailUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//, generator = "gmail_user_sequence_gen")
    @SequenceGenerator(name = "gmailuser_id_seq")
    @Column(name = "id")
    public Long Id;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    public GmailUser() {}
    public GmailUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
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
