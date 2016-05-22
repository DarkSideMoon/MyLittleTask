package com.greenowl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/main")
public class DashboardController {

    @RequestMapping(value = "/board", method= RequestMethod.GET)
    public ModelAndView logIn(ModelAndView  modelAndView) {
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
