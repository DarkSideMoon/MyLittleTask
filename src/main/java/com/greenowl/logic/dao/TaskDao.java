package com.greenowl.logic.dao;

import com.greenowl.model.Task;
import com.greenowl.model.User;

import java.util.List;

/**
 * Created by acube on 14.05.2016.
 */
public interface TaskDao<U> extends JdbcDao<Task> {

    List<U> getByTypeId(int id, User user);
    List<U> getByPrioritazing(int priority, User user);
    List<U> getAllInDone();

}
