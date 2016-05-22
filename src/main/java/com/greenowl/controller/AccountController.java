package com.greenowl.controller;

import com.greenowl.model.User;
import com.greenowl.service.TaskService;
import com.greenowl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

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
                              @RequestParam(value="pass") String pass) throws Exception {
        try {
            ModelAndView view = new ModelAndView();
            userService = new UserService();
            boolean result = userService.LogIn(email, pass);
            User user = userService.getUser(email, pass);

            if (result) {
                List<Integer> resTasksTypeCounts = taskService.getAllTasksByTypes();

                view.addObject("userInSystem", user.getName());
                view.addObject("allTasks", resTasksTypeCounts.get(3));
                view.addObject("homeTasks", resTasksTypeCounts.get(0));
                view.addObject("workTasks", resTasksTypeCounts.get(1));
                view.addObject("myTasks", resTasksTypeCounts.get(2));


                view.setViewName("dashboard");
                return view;
            } else {
                return new ModelAndView("redirect:/error/notfound?place=AccountController&&traceError=User NOT Found!");
            }
        }
        catch (Exception ex) {
            return new ModelAndView("redirect:/error/notfound?place=AccountController&&traceError=User NOT Found!");
        }
    }

    // Handler Registration form
    @RequestMapping(value = "/registrationUser", method= RequestMethod.POST)
    public ModelAndView registrationForm(@RequestParam(value="username") String userName,
            @RequestParam(value="email") String email,
            @RequestParam(value="pass") String pass,
            ModelAndView  modelAndView) {

        try {
            userService = new UserService();
            boolean result = userService.Register(userName, pass, email);

            if (result) {
                modelAndView.setViewName("login");
                return modelAndView;
            } else {
                return new ModelAndView("redirect:/error/notfound?place=AccountController&&traceError=Error registration new user!");
            }
        }
        catch (Exception ex) {
            return new ModelAndView("redirect:/error/notfound?place=AccountController&&traceError=Error registration new user!");
        }
    }
}