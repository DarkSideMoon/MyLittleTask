package com.greenowl.logic.dao;

import com.greenowl.model.User;

import java.util.List;

/**
 * Created by acube on 12.05.2016.
 */
public interface UserDao extends JdbcDao {

    List<User> getAllUsers();
}
