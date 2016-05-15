package com.greenowl.model;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by acube on 20.04.2016.
 */
@Entity
@Table(name="note")
@NamedQueries({
        @NamedQuery(name = "note.getAll", query = "SELECT w from Note w"),
        @NamedQuery(name = "note.getAchievable", query = "SELECT w from Note w where isArchiavable = true")
})

public class Note {

    // Fileds
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NoteID_seq")
    @SequenceGenerator(name = "NoteID_seq",
            sequenceName = "note_id_seq",
            allocationSize = 1,
            initialValue = 999999999)
    @Column(name = "id")
    public Long Id;

    @Column(name = "header")
    public String header;

    @Column(name = "body")
    public String body;

    @Column(name = "color")
    public String color;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date date;

    @Column(name = "isarchiavable")
    public boolean isArchiavable;

    @OneToOne(optional = false)
    @JoinColumn(name="userid", unique = true, nullable = false, updatable = false)
    public User User;

    // Constructors
    public Note() {}
    public Note(String header, String body, String color, Date date) {
        this.header = header;
        this.body = body;
        this.color = color;
        this.date = date;
    }

    // Getter and Setters
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public com.greenowl.model.User getUser() {
        return User;
    }
    public void setUser(com.greenowl.model.User user) {
        User = user;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }

    public boolean isArchiavable() {
        return isArchiavable;
    }
    public void setIsArchiavable(boolean isArchiavable) {
        this.isArchiavable = isArchiavable;
    }
}
