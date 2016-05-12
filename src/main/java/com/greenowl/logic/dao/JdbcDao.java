package com.greenowl.logic.dao;

import java.util.List;

/**
 * Created by acube on 12.05.2016.
 */
public interface JdbcDao {
    // -----------CRUD-----------
    // Create
    // Retrieve
    // Update
    // Delete
    void create(Object o);
    List retrieve(String queryString);
    void update(Object o);
    void delete(Object o);
}
