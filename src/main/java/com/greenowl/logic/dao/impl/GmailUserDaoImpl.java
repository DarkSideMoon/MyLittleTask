package com.greenowl.logic.dao.impl;

import com.greenowl.logic.dao.JdbcDao;
import com.greenowl.model.GmailUser;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by acube on 14.05.2016.
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application My Little Task
 */
@Repository
@SessionScoped
public class GmailUserDaoImpl implements JdbcDao<GmailUser>, Serializable {

    //@PersistenceContext
    private EntityManager entityManager;

    public GmailUserDaoImpl() {
        entityManager = Persistence.createEntityManagerFactory("MyLittleTask").createEntityManager();
    }

    public void create(GmailUser o) {
        entityManager.getTransaction().begin();
        entityManager.persist(o);
        entityManager.getTransaction().commit();
    }

    public GmailUser retrieve(int id) {
        return entityManager.find(GmailUser.class, (long)id);
    }

    public void update(GmailUser o) {
        entityManager.getTransaction().begin();
        entityManager.merge(o);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(this.retrieve(id));
        entityManager.getTransaction().commit();
    }

    public List<GmailUser> getAllUsers() {
        TypedQuery<GmailUser> namedQuery = entityManager.createNamedQuery("gmailuser.getAll", GmailUser.class);
        return namedQuery.getResultList();
    }
}
