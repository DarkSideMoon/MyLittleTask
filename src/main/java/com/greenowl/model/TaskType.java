package com.greenowl.model;

import javax.persistence.*;

/**
 * Created by acube on 10.05.2016.
 */
@Entity
@Table(name="tasktype")
@NamedQueries({
        @NamedQuery(name = "tasktype.getAll", query = "SELECT t from TaskType t"),
        @NamedQuery(name = "tasktype.getTypeByName", query = "SELECT w from TaskType w where name = :name")
})

public class TaskType {

    // Fileds
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TaskTypeID_seq")
    @SequenceGenerator(name = "TaskTypeID_seq",
            sequenceName = "tasktype_id_seq",
            allocationSize = 1,
            initialValue = 999999999)
    @Column(name = "id")
    public Long Id;

    @Column(name = "name")
    public String name;

    // Not mapped fields
    @Transient
    public Integer count;
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

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
}
