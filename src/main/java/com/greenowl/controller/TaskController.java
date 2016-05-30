package com.greenowl.controller;

import com.greenowl.model.Task;
import com.greenowl.model.TaskType;
import com.greenowl.model.User;
import com.greenowl.service.TaskService;
import com.greenowl.service.TaskTypeService;
import com.greenowl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
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
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskTypeService taskTypeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView handleGetAllTasks() throws Exception{

        User user = userService.getUser("123@asd", "12345");
        List<Task> tasks = taskService.getUserTasks(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allTasks");
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public ModelAndView handleGetMyTasks(ModelAndView modelView) throws Exception {

        User user = userService.getUser("123@asd", "12345");
        List<Task> myTasksList = taskService.getTasksByType(3, user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myTasks");
        modelAndView.addObject("myTasksList", myTasksList);
        return modelAndView;
    }

    @RequestMapping(value = "/work", method = RequestMethod.GET)
    public ModelAndView handleGetWorkTasks(ModelAndView modelView) throws Exception{
        User user = userService.getUser("123@asd", "12345");
        List<Task> workTasksList = taskService.getTasksByType(2, user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workTasks");
        modelAndView.addObject("workTasksList", workTasksList);
        return modelAndView;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView handleGetHomeTasks(ModelAndView modelView) throws Exception {
        User user = userService.getUser("123@asd", "12345");
        List<Task> homeTasksList = taskService.getTasksByType(1, user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homeTasks");
        modelAndView.addObject("homeTasksList", homeTasksList);
        return modelAndView;
    }

    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public ModelAndView handleGetAddPage() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addTask");
        return modelAndView;
    }

    @RequestMapping(value = "/addNewTask", method = RequestMethod.POST)
    public ModelAndView handleAddNewTask(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "priority") Integer priority,
                                         @RequestParam(value = "type") String type,
                                         @RequestParam(value = "body") String text,
                                         @RequestParam(value = "dateStart") Date dateStart,
                                         @RequestParam(value = "dateEnd") Date dateEnd) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if(name != null && priority != null && type != null
            && text != null && dateStart != null && dateEnd != null) {
            Task task = new Task();
            TaskType typeTask = taskTypeService.getTypeByName(type);
            User user = userService.getUser("123@asd", "12345");

            task.setName(name);
            task.setPrioritising(priority);
            task.setTaskType(typeTask);
            task.setBody(text);
            task.setIsDone(false);
            task.setDateCreate(dateStart);
            task.setDateDeadLine(dateEnd);
            task.setUser(user);

            try {
                taskService.addTask(task);
            } catch (Exception ex) {
                return new ModelAndView("redirect:/error/notfound?place=Add New Task Error&&traceError=Error to insert new task to DB!");
            }

            modelAndView.setViewName("addTask");
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/error/notfound?place=Add New Task&&traceError=You should input all fields!");
        }
    }

}
