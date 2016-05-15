package com.greenowl.logic.dao;

/**
 * Created by acube on 12.05.2016.
 * Package ${PACKAGE_NAME}
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
public interface JdbcDao<T> {
    // -----------CRUD-----------
    // Create
    // Retrieve
    // Update
    // Delete
    void create(T o);
    T retrieve(int id);
    void update(T o);
    void delete(int id);
}
