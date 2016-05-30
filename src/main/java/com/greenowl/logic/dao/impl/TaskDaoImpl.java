package com.greenowl.logic.dao.impl;

import com.greenowl.logic.dao.TaskDao;
import com.greenowl.model.Task;
import com.greenowl.model.TaskType;
import com.greenowl.model.User;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acube on 15.05.2016.
 * Package com.greenowl.logic.dao.impl
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Repository
@SessionScoped
public class TaskDaoImpl implements TaskDao<Task>, Serializable {

    //@PersistenceContext
    private EntityManager entityManager;

    public TaskDaoImpl() {
        entityManager = Persistence.createEntityManagerFactory("MyLittleTask").createEntityManager();
    }

    public void create(Task o) {
        entityManager.getTransaction().begin();
        entityManager.persist(o);
        entityManager.getTransaction().commit();
    }

    public Task retrieve(int id) {
        return entityManager.find(Task.class, (long)id);
    }

    public void update(Task o) {
        entityManager.getTransaction().begin();
        entityManager.merge(o);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(this.retrieve(id));
        entityManager.getTransaction().commit();
    }

    public List<Task> getByTypeId(int id, User user) {
        User us = user;
        TaskType type = new TaskType();
        type.Id = (long)id;

        TypedQuery<Task> namedQuery = entityManager.createNamedQuery("task.getByTypeId", Task.class)
                .setParameter("taskType", type)
                .setParameter("user", us);
        return namedQuery.getResultList();
    }

    public List<Task> getByPrioritazing(int priority, User user) {
        User us = user;

        TypedQuery<Task> namedQuery = entityManager.createNamedQuery("task.getByPrioritizing", Task.class)
                .setParameter("priority", priority)
                .setParameter("user", us);
        return namedQuery.getResultList();
    }

    public List<Task> getAllInDone() {
        TypedQuery<Task> namedQuery = entityManager.createNamedQuery("task.getAllInDone", Task.class);
        return namedQuery.getResultList();
    }

    public List<Task> getAll() {
        TypedQuery<Task> namedQuery = entityManager.createNamedQuery("task.getAll", Task.class);
        return namedQuery.getResultList();
    }

    public List<Integer> getTasksByTypes(User user) {
        List<Integer> result = new ArrayList<>();

        int homeTasksCount = this.getByTypeId(1, user).size();
        int workTasksCount = this.getByTypeId(2, user).size();
        int myTasksCount = this.getByTypeId(3, user).size();
        int allTasksCount = homeTasksCount + workTasksCount + myTasksCount;

        result.add(homeTasksCount);
        result.add(workTasksCount);
        result.add(myTasksCount);
        result.add(allTasksCount);
        return result;
    }

    public List<Task> getUserTasks(User user) {
        List<Task> result = new ArrayList<>();

        List<Task> homeTasks = this.getByTypeId(1, user);
        List<Task> workTasks = this.getByTypeId(2, user);
        List<Task> myTasks = this.getByTypeId(3, user);

        homeTasks.forEach(result::add);
        workTasks.forEach(result::add);
        myTasks.forEach(result::add);
        return result;
    }

}
