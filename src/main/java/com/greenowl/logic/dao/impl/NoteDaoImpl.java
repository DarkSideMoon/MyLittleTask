package com.greenowl.logic.dao.impl;

import com.greenowl.logic.dao.NoteDao;
import com.greenowl.model.Note;
import com.greenowl.model.User;
import org.springframework.stereotype.Repository;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by acube on 15.05.2016.
 * Package ${PACKAGE_NAME}
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Repository
@SessionScoped
public class NoteDaoImpl implements NoteDao<Note>, Serializable {

    //@PersistenceContext
    private EntityManager entityManager;

    public NoteDaoImpl() {
        entityManager = Persistence.createEntityManagerFactory("MyLittleTask").createEntityManager();
    }

    public List<Note> getAllNotes() {
        TypedQuery<Note> namedQuery = entityManager.createNamedQuery("note.getAll", Note.class);
        return namedQuery.getResultList();
    }

    public List<Note> getUserNotes(User us) {
        TypedQuery<Note> namedQuery = entityManager.createNamedQuery("note.getUserNotes", Note.class)
                .setParameter("user", us);
        return namedQuery.getResultList();
    }

    public void create(Note o) {
        entityManager.getTransaction().begin();
        entityManager.persist(o);
        entityManager.getTransaction().commit();
    }

    public Note retrieve(int id) {
        return entityManager.find(Note.class, (long)id);
    }

    public void update(Note o) {
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
