package com.greenowl.service;

import com.greenowl.logic.dao.impl.GenericDaoImpl;
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

    //@Autowired NOT find beas
    private GenericDaoImpl<TaskType> genericDao;

    public TaskTypeService() {
        this.genericDao = new GenericDaoImpl<TaskType>(TaskType.class);
    }

    public void createNewTaskType(TaskType type) {
        this.genericDao.create(type);
    }
}
