package com.greenowl.form;

import com.greenowl.model.Note;

import java.util.List;

/**
 * Created by acube on 06.06.2016.
 * Package com.greenowl.form
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
public class NoteForm {

    private List<Note> notes;
    private Boolean isDone;

    public  NoteForm() {}

    public List<Note> getNotes() {
        return notes;
    }
    public void setNotes(List<Note> tasks) {
        this.notes = tasks;
    }

    public Boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
}
