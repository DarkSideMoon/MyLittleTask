package com.greenowl.logic.dao;

import com.greenowl.model.Task;

import java.util.List;

/**
 * Created by acube on 14.05.2016.
 */
public interface TaskDao<U> extends JdbcDao<Task> {

    List<U> getByTypeId(int id);
    List<U> getByPrioritazing(int priority);
    List<U> getAllInDone();

}
