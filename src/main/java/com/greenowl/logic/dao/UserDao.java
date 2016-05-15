package com.greenowl.logic.dao;

import com.greenowl.model.User;

import java.util.List;

/**
 * Created by acube on 12.05.2016.
 * Package ${PACKAGE_NAME}
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
public interface UserDao<U> extends JdbcDao<User> {

    List<User> getAllUsers();
}
