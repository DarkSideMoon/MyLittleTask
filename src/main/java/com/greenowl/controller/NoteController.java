package com.greenowl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public ModelAndView logInForm(@RequestParam(value="note") String note) throws Exception {
        try {
            ModelAndView view = new ModelAndView();

            view.setViewName("notes");
            return view;
        }
        catch (Exception ex) {
            return new ModelAndView("redirect:/error/notfound?place=Google Auth&&traceError=" + ex.getMessage());
        }
    }

    @RequestMapping(value="/my", method = RequestMethod.GET)
    public ModelAndView googlePage () throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        return modelAndView;
    }

}
