package com.greenowl.logic.dao;

import com.greenowl.model.Note;

import java.util.List;

/**
 * Created by acube on 14.05.2016.
 */
public interface NoteDao<U> extends JdbcDao<Note> {

    List<U> getAllNotes();
}
