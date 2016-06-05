import com.greenowl.logic.dao.impl.NoteDaoImpl;
import com.greenowl.model.Note;
import com.greenowl.model.User;
import com.greenowl.service.NoteService;
import com.greenowl.service.UserService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by acube on 15.05.2016.
 * Package PACKAGE_NAME
 *
 * WORKS ONLY WITH LOCAL DB - POSTGRES !!!!!!!!!
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
public class TestNoteJPA {

    /*
    @Test
    public void TestCreateNote() {
        User user = new User();
        user.Id = (long)11;

        Note note = new Note();
        note.header = "Do mu homework";
        note.body = "Do all my homework";
        note.color = "green";
        note.date = new Date();
        note.isArchiavable = true;
        note.user = user;

        NoteDaoImpl dao = new NoteDaoImpl();
        dao.create(note);
    }

    @Test
    public void TestGetAll() {
        NoteDaoImpl dao = new NoteDaoImpl();
        List<Note> allNotes = dao.getAllNotes();
    }


    @Test
    public void TestGeUserNotes() {
        UserService userService = new UserService();
        NoteService noteService = new NoteService();

        User user = userService.getUser("123@asd", "12345");
        List<Note> allNotes = noteService.getUserNotes(user);

        Assert.assertNotNull(allNotes);
    }
    */

}
