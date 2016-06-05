package com.greenowl.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by acube on 20.04.2016.
 * Package ${PACKAGE_NAME}
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Entity
@Table(name="task")
@NamedQueries({
        @NamedQuery(name = "task.getAll", query = "SELECT w from Task w"),
        @NamedQuery(name = "task.getByPrioritizing", query = "SELECT w from Task w where prioritising = :priority and user = :user"),
        @NamedQuery(name = "task.getByTypeId", query = "SELECT w from Task w where taskType = :taskType and user = :user"),
        @NamedQuery(name = "task.getAllInDone", query = "SELECT w from Task w where isDone = true")
})
public class Task  {

    // Fields
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TaskID_seq")
    @SequenceGenerator(name = "TaskID_seq",
            sequenceName = "task_id_seq",
            allocationSize = 1,
            initialValue = 999999999)
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
    public int prioritising;

    @OneToOne(optional = false)
    @JoinColumn(name="typeid", unique = true, nullable = false, updatable = false)
    public TaskType taskType;

    //@ManyToOne(targetEntity=User.class)
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="userid", unique = true, nullable = false, updatable = true)
    public User user;

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

    public int getPrioritising() {
        return prioritising;
    }
    public void setPrioritising(int prioritising) {
        this.prioritising = prioritising;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}