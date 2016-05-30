package com.greenowl.service;

import com.greenowl.logic.dao.impl.UserDaoImpl;
import com.greenowl.model.SimpleHashPass;
import com.greenowl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by acube on 15.05.2016.
 * Package com.greenowl.service
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Component
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }

    @Transactional
    public void addUser(User user) {
        userDao.create(user);
    }

    @Transactional
    public boolean LogIn(String email, String password) {
        SimpleHashPass hashPass = new SimpleHashPass();
        hashPass.password = password;

        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.retrieve(email, hashPass.HashPass());

        return (user != null);
    }

    @Transactional
    public boolean Register(String name, String pass, String email) {
        // Check if User with email exist in DB
        List<User> existUsers = userDao.retrieve(email);
        if(existUsers != null && existUsers.size() >= 1)
            return false;

        SimpleHashPass hashPass = new SimpleHashPass();
        User user = new User();
        user.name = name;
        user.email = email;

        hashPass.password = pass;
        user.password = hashPass.HashPass();

        userDao.create(user);
        return true;
    }

    //@Transactional
    public User getUser(String email, String pass) {
        SimpleHashPass hashPass = new SimpleHashPass();
        hashPass.password = pass;
        return userDao.retrieve(email, hashPass.HashPass());
    }
}
