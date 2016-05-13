package com.greenowl.logic.dao;

import java.util.List;

/**
 * Created by acube on 12.05.2016.
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
    void delete(T o);
}
