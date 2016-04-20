package com.greenowl.model;

import java.sql.Date;

/**
 * Created by acube on 20.04.2016.
 */
public class Task  {

    public String name;
    public String body;

    public boolean isDone;

    public Date dateCreate;
    public Date dateDeadLine;

    public Task(String name, String body, boolean isDone, Date create, Date deadLine) {
        this.name = name;
        this.body = body;
        this.isDone = isDone;
        this.dateCreate = create;
        this.dateDeadLine = deadLine;
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

    public boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
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
}
