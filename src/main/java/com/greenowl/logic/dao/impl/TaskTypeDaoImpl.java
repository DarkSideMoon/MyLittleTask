package com.greenowl.logic.dao.impl;

import com.greenowl.logic.dao.JdbcDao;
import com.greenowl.logic.dao.TaskDao;
import com.greenowl.model.Task;
import com.greenowl.model.TaskType;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Created by acube on 30.05.2016.
 * Package com.greenowl.logic.dao.impl
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Repository
@SessionScoped
public class TaskTypeDaoImpl implements JdbcDao<TaskType> {

    private EntityManager entityManager;

    public TaskTypeDaoImpl() {
        entityManager = Persistence.createEntityManagerFactory("MyLittleTask").createEntityManager();
    }

    public void create(TaskType o) {
        entityManager.getTransaction().begin();
        entityManager.persist(o);
        entityManager.getTransaction().commit();
    }

    public TaskType retrieve(int id) {
        return entityManager.find(TaskType.class, (long)id);
    }

    public void update(TaskType o) {
        entityManager.getTransaction().begin();
        entityManager.merge(o);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(this.retrieve(id));
        entityManager.getTransaction().commit();
    }

    public TaskType getByNameTaskType(String name) {
        TypedQuery<TaskType> namedQuery = entityManager.createNamedQuery("tasktype.getTypeByName", TaskType.class)
                .setParameter("name", name);
        return namedQuery.getSingleResult();
    }
}
