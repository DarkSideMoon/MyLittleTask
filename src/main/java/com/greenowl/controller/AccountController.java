package com.greenowl.controller;

import com.greenowl.model.SimpleHashPass;
import com.greenowl.model.Task;
import com.greenowl.model.User;
import com.greenowl.service.TaskService;
import com.greenowl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public ModelAndView handleRequestLogin(ModelAndView modelView) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    // Return registration page
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView handleRequestRegistration(ModelAndView modelView) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value="/my", method = RequestMethod.GET)
    public ModelAndView accountPage () {
        User user = userService.getUser("123@asd", "12345");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("email", user.getEmail());
        modelAndView.setViewName("myAccount");
        return modelAndView;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public ModelAndView saveUser (@RequestParam(value = "name") String name,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "passwordOld") String passOld,
                                  @RequestParam(value = "passwordNew") String passNew) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUser("123@asd", "12345");
        SimpleHashPass hash = new SimpleHashPass(passOld);
        String passHash = hash.HashPass();

        if(!Objects.equals(user.password, passHash)) {
            modelAndView.addObject("passNotMatch", true);
        } else {
            if(passNew != null) {
                user.password = hash.HashPass();
                hash.password = passNew;
            }

            user.name = name;
            user.email = email;

            userService.updateUser(user);

            modelAndView.addObject("correct", true);
        }
        modelAndView.setViewName("myAccount");
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
                List<Integer> resTasksTypeCounts = taskService.getAllTasksByTypes(user);
                List<Task> tempTasks = taskService.getTasksByPriority(1, user);
                List<Task> importatnTasksList = tempTasks
                        .stream()
                        .filter(t -> !t.isDone)
                        .collect(Collectors.toList());

                int temp = resTasksTypeCounts.get(3);
                int allTasksCount = temp == 0 || user == null ? 0 : temp;

                temp = resTasksTypeCounts.get(0);
                int homeTasksCount = temp == 0 || user == null ? 0 : temp;

                temp = resTasksTypeCounts.get(1);
                int workTasksCount = temp == 0 || user == null ? 0 : temp;

                temp = resTasksTypeCounts.get(2);
                int myTasksCount = temp == 0 || user == null ? 0 : temp;



                view.addObject("userInSystem", user != null ? user.getName() : null);
                view.addObject("allTasks", allTasksCount);
                view.addObject("homeTasks", homeTasksCount);
                view.addObject("workTasks", workTasksCount);
                view.addObject("myTasks", myTasksCount);
                view.addObject("importantTasksList", importatnTasksList);


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
            ModelAndView modelAndView) {

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

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("errorIn", "403 Access denied!");
        modelAndView.addObject("stackTrace", "You are not authorized to access this page");
        modelAndView.setViewName("error");
        return modelAndView;
    }
}