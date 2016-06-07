package com.greenowl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by acube on 18.05.2016.
 * Package com.greenowl.controller
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Controller
@RequestMapping("/info")
public class AboutController {

    // Start page
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView handleRequestStart(HttpServletRequest request) throws Exception {
        ModelAndView model = new ModelAndView();
        model.setViewName("about");

        return model;
    }
}
