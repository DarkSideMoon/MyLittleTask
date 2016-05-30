package com.greenowl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by acube on 27.03.2016.
 */
@org.springframework.stereotype.Controller
public class HomeController   {

    // Start page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView handleRequestStart() throws Exception {
        ModelAndView model = new ModelAndView();
        model.setViewName("../index");

        return model;
    }

    // Dashboard
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView handleRequestDashboard(ModelAndView modelView) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
