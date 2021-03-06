package com.greenowl.form;

import com.greenowl.model.Task;

import java.util.List;

/**
 * Created by acube on 05.06.2016.
 * Package com.greenowl.form
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
public class AllTasksForm {

    private List<Task> tasks;
    private Boolean isDone;

    public  AllTasksForm() {}

    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
}
