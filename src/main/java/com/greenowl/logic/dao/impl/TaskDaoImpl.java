package com.greenowl.logic.dao.impl;

import com.greenowl.logic.dao.TaskDao;
import com.greenowl.model.Task;
import com.greenowl.model.TaskType;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
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

    @PersistenceContext
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

    public List<Task> getByTypeId(int id) {
        TaskType type = new TaskType();
        type.Id = (long)id;

        TypedQuery<Task> namedQuery = entityManager.createNamedQuery("task.getByTypeId", Task.class)
                .setParameter("taskType", type);
        return namedQuery.getResultList();
    }

    public List<Task> getByPrioritazing(int priority) {
        TypedQuery<Task> namedQuery = entityManager.createNamedQuery("task.getByPrioritizing", Task.class)
                .setParameter("priority", priority);
        return namedQuery.getResultList();
    }

    public List<Task> getAllInDone() {
        TypedQuery<Task> namedQuery = entityManager.createNamedQuery("task.getAllInDone", Task.class);
        return namedQuery.getResultList();
    }

    public List<Task> getAll() {
        TypedQuery<Task> namedQuery = entityManager.createNamedQuery("task.getAll", Task.class);
        return namedQuery.getResultList();    }

}
