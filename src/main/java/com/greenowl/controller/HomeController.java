package com.greenowl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by acube on 27.03.2016.
 */
@org.springframework.stereotype.Controller
public class HomeController   {

    // Start page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView handleRequest(ModelAndView  modelAndView) throws Exception {
        ModelAndView model = new ModelAndView();
        model.setViewName("../index");

        return model;
    }
}
