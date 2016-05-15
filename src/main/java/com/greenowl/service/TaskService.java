package com.greenowl.service;

import com.greenowl.logic.dao.impl.TaskDaoImpl;
import com.greenowl.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by acube on 15.05.2016.
 * Package com.greenowl.service
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Component
public class TaskService {

    @Autowired
    private TaskDaoImpl taskDao;

    public TaskService() {
        this.taskDao = new TaskDaoImpl();
    }

    public void addTask(Task task) {
        this.taskDao.create(task);
    }

    public void updateTask(Task task) {
        this.taskDao.update(task);
    }

    public void deleteTask(int id) {
        this.taskDao.delete(id);
    }

    public List<Task> getAllTasks() {
        return this.taskDao.getAll();
    }

    public List<Task> getAllDoneTasks() {
        return this.taskDao.getAllInDone();
    }

    public List<Task> getTasksByType(int typeId) {
        return this.taskDao.getByTypeId(typeId);
    }

    public List<Task> getTasksByPriority(int priorityId) {
        return this.taskDao.getByPrioritazing(priorityId);
    }
}