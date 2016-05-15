package com.greenowl.logic.dao.impl;

import com.greenowl.logic.dao.UserDao;
import com.greenowl.model.User;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by acube on 12.05.2016.
 * Package ${PACKAGE_NAME}
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
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
        TypedQuery<User> namedQuery = entityManager.createNamedQuery("appuser.getAll", User.class);
        return namedQuery.getResultList();
    }

    public void create(User o) {
        entityManager.getTransaction().begin();
        entityManager.persist(o);
        entityManager.getTransaction().commit();
    }

    public User retrieve(int id) {
        return entityManager.find(User.class, (long)id);
    }

    public User retrieve(String email, String pass) {
        try {
            TypedQuery<User> namedQuery = entityManager.createNamedQuery("appuser.findUser", User.class)
                    .setParameter("email", email)
                    .setParameter("pass", pass);
            return namedQuery.getSingleResult();
        }
        catch (Exception ex) {
            return null;
        }
    }

    public List<User> retrieve(String email) {
        try {
            TypedQuery<User> namedQuery = entityManager.createNamedQuery("appuser.findUserByEmail", User.class)
                    .setParameter("email", email);
            return namedQuery.getResultList();
        }
        catch (Exception ex) {
            return null;
        }
    }

    public void update(User o) {
        entityManager.getTransaction().begin();
        entityManager.merge(o);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(this.retrieve(id));
        entityManager.getTransaction().commit();
    }
}
