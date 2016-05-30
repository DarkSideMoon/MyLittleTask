package com.greenowl.model;

import javax.persistence.*;

/**
 * Created by acube on 10.05.2016.
 * Package ${PACKAGE_NAME}
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask2
 */
@Entity
@Table(name="user_in_task")
public class UserTask {

    // Fileds
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserInTask_seq")
    @SequenceGenerator(name = "UserInTask_seq",
            sequenceName = "user_in_task_id_seq",
            allocationSize = 1,
            initialValue = 999999999)
    @Column(name = "id")
    public Long Id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="userid", nullable = false)
    public User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="taskid", nullable = false)
    public Task task;

    // Constructors
    public UserTask() {}

    // Getter and Setters

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }
    public void setTask(Task task) {
        this.task = task;
    }
}
