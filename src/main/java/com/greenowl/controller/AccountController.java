package com.greenowl.controller;

import com.greenowl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    // Retrun login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView handleRequestLogin(ModelAndView  modelView) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    // Return registration page
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView handleRequestRegistration(ModelAndView  modelView) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    // Handler LogIn form
    @RequestMapping(value = "/loginUser", method= RequestMethod.POST)
    public ModelAndView logInForm(@RequestParam(value="email") String email,
                              @RequestParam(value="pass") String pass,
                              ModelAndView  modelAndView) {
        userService = new UserService();
        boolean result = userService.LogIn(email, pass);

        if(result) {
            //modelAndView.addObject("userName", userName);
            modelAndView.setViewName("dashboard");
            return modelAndView;
        } else {
            modelAndView.setViewName("blank");
            return modelAndView;
        }
    }

    // Handler Registration form
    @RequestMapping(value = "/registrationUser", method= RequestMethod.POST)
    public boolean registrationForm(@RequestParam(value="username") String userName,
            @RequestParam(value="email") String email,
            @RequestParam(value="pass") String pass,
            ModelAndView  modelAndView) {

        userService = new UserService();
        return userService.Register(userName, pass, email);
    }

}
