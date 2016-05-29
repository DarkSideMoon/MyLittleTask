package com.greenowl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by acube on 19.05.2016.
 * Package com.greenowl.controller
 *
 * @author Pavel Romashchenko (DarkSideMoon)
 * @version 0.0.0.1
 * @application MyLittleTask
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping(value = "/notfound", params = {"place", "traceError"}, method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView handleErrorView(@RequestParam(value="place") String place,
                                        @RequestParam(value="traceError") String trace) throws Exception{ //
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorIn", "Error in " + place);
        modelAndView.addObject("stackTrace", trace);
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public ModelAndView handleErrorViewAccessDenied() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorIn", "Error in ");
        modelAndView.addObject("stackTrace", "");
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView handleErrorView() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorIn", "Error in ");
        modelAndView.addObject("stackTrace", "");
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
