package com.greenowl.logic.dao.impl;

import com.greenowl.logic.dao.UserDao;
import com.greenowl.model.User;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by acube on 12.05.2016.
 */
@Repository
@SessionScoped
public class UserDaoImpl implements UserDao<User>, Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
        entityManager = Persistence.createEntityManagerFactory("MyLittleTask").createEntityManager();
    }

    public List<User> getAllUsers() {
        TypedQuery<User> namedQuery = (TypedQuery<User>) entityManager.createNamedQuery("user.getAll");
        return namedQuery.getResultList();
    }

    public void create(User o) {
        entityManager.getTransaction().begin();
        entityManager.persist(o);
        entityManager.getTransaction().commit();
    }

    public User retrieve(int id) {
        return entityManager.find(User.class, id);
    }

    public void update(User o) {
        entityManager.getTransaction().begin();
        entityManager.merge(o);
        entityManager.getTransaction().commit();
    }

    public void delete(User o) {
        entityManager.getTransaction().begin();
        entityManager.remove(o);
        entityManager.getTransaction().commit();
    }
}
