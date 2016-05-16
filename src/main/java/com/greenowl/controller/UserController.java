package com.greenowl.controller;

import com.greenowl.model.User;
import com.greenowl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by acube on 15.05.2016.
 * Package com.greenowl.controller
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Controller
@RequestMapping("view/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "view/user/login", method= RequestMethod.POST)
    public ModelAndView logIn(@RequestParam(value="email") String email,
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

    @RequestMapping(value = "view/get", method= RequestMethod.GET)
    public ModelAndView logIn(ModelAndView  modelAndView) {
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }
}
