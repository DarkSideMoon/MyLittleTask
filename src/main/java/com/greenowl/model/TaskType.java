package com.greenowl.model;

import javax.persistence.*;

/**
 * Created by acube on 10.05.2016.
 */
@Entity
@Table(name="tasktype")
@NamedQuery(name = "tasktype.getAll", query = "SELECT t from TaskType t")
public class TaskType {

    // Fileds
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

    // Constructors
    public TaskType() {}

    // Getter and Setters
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
