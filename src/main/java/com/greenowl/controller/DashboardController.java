package com.greenowl.controller;

import com.greenowl.config.WebSecurity;
import com.greenowl.model.Task;
import com.greenowl.model.User;
import com.greenowl.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
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
@RequestMapping("/main")
public class DashboardController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/board", method= RequestMethod.GET)
    public ModelAndView logIn(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        User user = WebSecurity.getCurrentUser();
        Boolean isTransaction = WebSecurity.checkTransaction(request.getSession().getId());
        if(!isTransaction)
            return new ModelAndView("redirect:/error/notfound?place=HTTP Status 403&&traceError=Access is denied!");

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
        view.addObject("userInSystem", user != null ? user.getName() : null);

        view.setViewName("dashboard");
        return view;
    }
}
