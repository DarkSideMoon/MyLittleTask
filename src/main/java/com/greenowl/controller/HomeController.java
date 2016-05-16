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
public class HomeController implements Controller  {

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");

        return model;
    }
}
