package com.greenowl.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by acube on 20.04.2016.
 */
@Entity
@Table(name="note")
@NamedQueries({
        @NamedQuery(name = "note.getAll", query = "SELECT w from Note w"),
        @NamedQuery(name = "note.getUserNotes", query = "SELECT w from Note w where user = :user")
})

public class Note {

    // Fileds
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NoteID_seq")
    @SequenceGenerator(name = "NoteID_seq",
            sequenceName = "note_id_seq",
            allocationSize = 1,
            initialValue = 999999999)
    @Column(name = "id")
    public Long Id;

    @Column(name = "body")
    public String body;

    @Column(name = "isdone")
    public Boolean isDone;

    @OneToOne(optional = false)
    @JoinColumn(name="userid", unique = true, nullable = false, updatable = false)
    public User user;

    @Transient
    public String header;

    @Transient
    public String color;

    @Transient
    public Date date;

    @Transient
    public boolean isArchiavable;

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
        return user;
    }
    public void setUser(com.greenowl.model.User user) {
        this.user = user;
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

    public Boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
}
