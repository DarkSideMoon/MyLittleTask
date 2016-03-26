package com.greenowl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by acube on 27.03.2016.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String RegistrationPage() {
        return "view/registration.jsp";
    }
}
