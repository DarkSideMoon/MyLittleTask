package com.greenowl.controller;

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
@RequestMapping("/web")
public class WebController {

    // Handler LogIn form
    @RequestMapping(value = "/googleLogin", method= RequestMethod.POST)
    public ModelAndView logInForm(@RequestParam(value="email") String email,
                                  @RequestParam(value="pass") String pass) throws Exception {
        try {
            ModelAndView view = new ModelAndView();

            boolean result = true;
            if (result) {
                view.setViewName("dashboard");
                return view;
            } else {
                view.setViewName("web");
                return view;
            }
        }
        catch (Exception ex) {
            return new ModelAndView("redirect:/error/notfound?place=Google Auth&&traceError=" + ex.getMessage());
        }
    }
}
