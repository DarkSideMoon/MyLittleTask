package com.greenowl.service;

import com.greenowl.logic.dao.impl.NoteDaoImpl;
import com.greenowl.model.Note;

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

    @Transactional
    public void addNote(Note note) {
        noteDao.create(note);
    }

    public void updateNote(Note note) {
        noteDao.update(note);
    }

    public void setNoteArchive(Note note) {
        note.isArchiavable = true;
        noteDao.update(note);
    }

    @Transactional(readOnly = true)
    public List<Note> getAllNotes() {
        return noteDao.getAllNotes();
    }

    @Transactional(readOnly = true)
    public List<Note> getArchiveNotes() {
        return noteDao.getAllArchiavables();
    }
}
