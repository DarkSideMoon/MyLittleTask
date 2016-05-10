package com.greenowl.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by acube on 20.04.2016.
 */
@Entity
@Table(name="task")
@NamedQuery(name = "task.getAll", query = "SELECT w from Task w")
public class Task  {

    // Fields
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long Id;

    @Column(name = "name")
    public String name;

    @Column(name = "body")
    public String body;

    @Column(name = "isdone")
    public boolean isDone;

    @Column(name = "datecreate")
    public Date dateCreate;

    @Column(name = "datedeadline")
    public Date dateDeadLine;

    @Column(name = "prioritising")
    public Integer prioritising;

    @OneToOne(optional = false)
    @JoinColumn(name="typeid", unique = true, nullable = false, updatable = false)
    public TaskType taskType;

    // Constructors
    public Task() {}
    public Task(String name, String body, boolean isDone, Date create, Date deadLine) {
        this.name = name;
        this.body = body;
        this.isDone = isDone;
        this.dateCreate = create;
        this.dateDeadLine = deadLine;
    }

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

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateDeadLine() {
        return dateDeadLine;
    }
    public void setDateDeadLine(Date dateDeadLine) {
        this.dateDeadLine = dateDeadLine;
    }

    public Date getDateCreate() {
        return dateCreate;
    }
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isDone() {
        return isDone;
    }
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public TaskType getTaskType() {
        return taskType;
    }
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }
}