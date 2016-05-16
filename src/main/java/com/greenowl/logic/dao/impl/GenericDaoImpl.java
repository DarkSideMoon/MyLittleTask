package com.greenowl.logic.dao.impl;


import com.greenowl.logic.dao.JdbcDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Generic DAO for all clases that does not have own DAO interface
 * which extends functionality
 *
 * Generic DAO for: TaskType.java
 *
 * Created by acube on 15.05.2016.
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application My Little Task
 */
//
public class GenericDaoImpl<T> implements JdbcDao<T> {

    private final Class<T> typeParameterClass;

    //@PersistenceContext
    private EntityManager entityManager;

    // Define the Class
    public GenericDaoImpl(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
        entityManager = Persistence.createEntityManagerFactory("MyLittleTask").createEntityManager();
    }

    public void create(T o) {
        entityManager.getTransaction().begin();
        entityManager.persist(o);
        entityManager.getTransaction().commit();
    }

    public T retrieve(int id) {
        return entityManager.find(typeParameterClass, (long)id);
    }

    public void update(T o) {
        entityManager.getTransaction().begin();
        entityManager.merge(o);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(this.retrieve(id));
        entityManager.getTransaction().commit();
    }

    public List<T> getAllUsers(String queryName) {
        TypedQuery<T> namedQuery = entityManager.createNamedQuery(queryName, typeParameterClass);
        return namedQuery.getResultList();
    }
}
