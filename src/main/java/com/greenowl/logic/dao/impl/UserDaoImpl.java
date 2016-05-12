package com.greenowl.logic.dao.impl;

import com.greenowl.logic.dao.UserDao;
import com.greenowl.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by acube on 12.05.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return null;
    }

    public void create(Object o) {

    }

    public List retrieve(String queryString) {
        return null;
    }

    public void update(Object o) {

    }

    public void delete(Object o) {

    }
}
