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

 SELECT id, name, email, gmailauth, gmailuser from appuser
 */
@Entity(name = "appuser")
@Table(name="appuser")
@NamedQueries({
        @NamedQuery(name = "appuser.getAll", query = "SELECT ap from appuser ap"),
        @NamedQuery(name = "appuser.findUser", query = "SELECT ap from appuser ap where email = :email AND password = :pass"),
        @NamedQuery(name = "appuser.findUserByEmail", query = "SELECT ap from appuser ap where email = :email")
})
public class User {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserID_seq")
    @SequenceGenerator(name = "UserID_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1,
            initialValue = 999999999)
    @Column(name = "id")
    public Long Id;

    @Column(name = "name")
    public String name;

    @Column(name = "password")
    public String password;

    @Column(name = "email")
    public String email;

    @Column(name = "gmailauth")
    public boolean gmailauth;

    @OneToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name="gmailuser", nullable = true)
    public GmailUser gmailuser;

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

    public boolean isGmailauth() {
        return gmailauth;
    }
    public void setIsGmailAuth(boolean isGmailAuth) {
        this.gmailauth = isGmailAuth;
    }

    public GmailUser getGmailuser() {
        return gmailuser;
    }
    public void setGmailuser(GmailUser gmailuser) {
        this.gmailuser = gmailuser;
    }
}
