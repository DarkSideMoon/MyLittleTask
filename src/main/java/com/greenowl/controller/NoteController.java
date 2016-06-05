package com.greenowl.controller;

import com.greenowl.model.Note;
import com.greenowl.model.User;
import com.greenowl.service.NoteService;
import com.greenowl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by acube on 18.05.2016.
 * Package com.greenowl.controller
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private UserService userService;

    @Autowired
    public NoteService noteService;

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public ModelAndView logInForm(@RequestParam(value="note") String body) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            User user = userService.getUser("123@asd", "12345");

            Note note = new Note();
            note.setUser(user);
            note.setBody(body);
            note.setIsDone(false);

            try {
                noteService.addNote(note);
            } catch (Exception ex) {
                view.addObject("success", false);
                return new ModelAndView("redirect:/error/notfound?place=Note Control&&traceError=" + ex.getMessage());
            }

            List<Note> allNotes = noteService.getUserNotes(user);
            view.addObject("notes", allNotes);
            view.addObject("success", true);
            view.setViewName("notes");
            return view;
        }
        catch (Exception ex) {
            view.addObject("success", false);
            return new ModelAndView("redirect:/error/notfound?place=Note Control&&traceError=" + ex.getMessage());
        }
    }

    @RequestMapping(value="/my", method = RequestMethod.GET)
    public ModelAndView googlePage () throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUser("123@asd", "12345");
        List<Note> allNotes = noteService.getUserNotes(user);

        modelAndView.addObject("notes", allNotes);
        modelAndView.setViewName("notes");
        return modelAndView;
    }

}