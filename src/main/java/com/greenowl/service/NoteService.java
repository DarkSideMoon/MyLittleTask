package com.greenowl.service;

import com.greenowl.logic.dao.impl.NoteDaoImpl;
import com.greenowl.model.Note;
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
public class NoteService {

    @Autowired
    private NoteDaoImpl noteDao;

    public NoteService() {
        noteDao = new NoteDaoImpl();
    }

    public void addNote(Note note) {
        noteDao.create(note);
    }

    public void updateNote(Note note) {
        noteDao.update(note);
    }

    public void deleteNote(int id) {
        noteDao.delete(id);
    }

    public void setNoteArchive(Note note) {
        note.isArchiavable = true;
        noteDao.update(note);
    }


    public List<Note> getAllNotes() {
        return noteDao.getAllNotes();
    }

    //@Transactional(readOnly = true)
    public List<Note> getUserNotes(User user) {
        return noteDao.getUserNotes(user);
    }
}
