package com.greenowl.service;

import com.greenowl.logic.dao.impl.GenericDaoImpl;
import com.greenowl.logic.dao.impl.TaskDaoImpl;
import com.greenowl.logic.dao.impl.TaskTypeDaoImpl;
import com.greenowl.model.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by acube on 15.05.2016.
 * Package com.greenowl.service
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Component
public class TaskTypeService {

    @Autowired
    private TaskTypeDaoImpl taskTypeDao;

    public TaskTypeService() {
        this.taskTypeDao = new TaskTypeDaoImpl();
    }

    public void createNewTaskType(TaskType type) {
        this.taskTypeDao.create(type);
    }

    public TaskType getTypeByName(String name) {
        return this.taskTypeDao.getByNameTaskType(name);
    }
}
