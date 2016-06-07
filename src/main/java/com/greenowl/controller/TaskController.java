package com.greenowl.controller;

import com.greenowl.config.WebSecurity;
import com.greenowl.form.AllTasksForm;
import com.greenowl.model.Task;
import com.greenowl.model.TaskType;
import com.greenowl.model.User;
import com.greenowl.service.TaskService;
import com.greenowl.service.TaskTypeService;
import com.greenowl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
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

    public TaskController() {}

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView handleGetAllTasks(HttpServletRequest request) throws Exception{

        User user = WebSecurity.getCurrentUser();
        Boolean isTransaction = WebSecurity.checkTransaction(request.getSession().getId());
        if(!isTransaction)
            return new ModelAndView("redirect:/error/notfound?place=HTTP Status 403&&traceError=Access is denied!");

        List<Task> tasks = taskService.getUserTasks(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allTasks");
        modelAndView.addObject("tasks", tasks);
        modelAndView.addObject("isEdit", false);
        return modelAndView;
    }

    @RequestMapping(value = "/allEditable", method = RequestMethod.GET)
    public ModelAndView handleGetAllTasksEdit(HttpServletRequest request) throws Exception{

        User user = WebSecurity.getCurrentUser();
        Boolean isTransaction = WebSecurity.checkTransaction(request.getSession().getId());
        if(!isTransaction)
            return new ModelAndView("redirect:/error/notfound?place=HTTP Status 403&&traceError=Access is denied!");

        List<Task> tasks = taskService.getUserTasks(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allTasks");
        modelAndView.addObject("tasks", tasks);
        modelAndView.addObject("isEdit", true);
        return modelAndView;
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public ModelAndView handleGetMyTasks(HttpServletRequest request) throws Exception {

        User user = WebSecurity.getCurrentUser();
        Boolean isTransaction = WebSecurity.checkTransaction(request.getSession().getId());
        if(!isTransaction)
            return new ModelAndView("redirect:/error/notfound?place=HTTP Status 403&&traceError=Access is denied!");

        List<Task> myTasksList = taskService.getTasksByType(3, user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myTasks");
        modelAndView.addObject("myTasksList", myTasksList);
        return modelAndView;
    }

    @RequestMapping(value = "/work", method = RequestMethod.GET)
    public ModelAndView handleGetWorkTasks(HttpServletRequest request) throws Exception{

        User user = WebSecurity.getCurrentUser();
        Boolean isTransaction = WebSecurity.checkTransaction(request.getSession().getId());
        if(!isTransaction)
            return new ModelAndView("redirect:/error/notfound?place=HTTP Status 403&&traceError=Access is denied!");

        List<Task> workTasksList = taskService.getTasksByType(2, user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workTasks");
        modelAndView.addObject("workTasksList", workTasksList);
        return modelAndView;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView handleGetHomeTasks(HttpServletRequest request) throws Exception {
        User user = WebSecurity.getCurrentUser();
        Boolean isTransaction = WebSecurity.checkTransaction(request.getSession().getId());
        if(!isTransaction)
            return new ModelAndView("redirect:/error/notfound?place=HTTP Status 403&&traceError=Access is denied!");

        List<Task> homeTasksList = taskService.getTasksByType(1, user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homeTasks");
        modelAndView.addObject("homeTasksList", homeTasksList);
        return modelAndView;
    }

    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public ModelAndView handleGetAddPage(HttpServletRequest request) throws Exception {

        Boolean isTransaction = WebSecurity.checkTransaction(request.getSession().getId());
        if(!isTransaction)
            return new ModelAndView("redirect:/error/notfound?place=HTTP Status 403&&traceError=Access is denied!");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addTask");
        return modelAndView;
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public ModelAndView handleAddNewTask(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "priority") Integer priority,
                                         @RequestParam(value = "type") String type,
                                         @RequestParam(value = "body") String text,
                                         @RequestParam(value = "dateStart") Date dateStart,
                                         @RequestParam(value = "dateEnd") Date dateEnd
                                         ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("datetime", new Date());

        if(name != null && priority != null && type != null
            && text != null && dateStart != null && dateEnd != null) {
            Task task = new Task();
            TaskType typeTask = taskTypeService.getTypeByName(type);
            User user = WebSecurity.getCurrentUser();

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
                modelAndView.addObject("success", true);
            } catch (Exception ex) {
                modelAndView.addObject("success", false);
                return new ModelAndView("redirect:/error/notfound?place=Add New Task Error&&traceError=Error to insert new task to DB!");
            }

            modelAndView.setViewName("addTask");
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/error/notfound?place=Add New Task&&traceError=You should input all fields!");
        }
    }

    @RequestMapping(value = "/updateTasks", method = RequestMethod.POST)
    public ModelAndView updateAllTasks(@ModelAttribute("tasksForm") AllTasksForm tasksForm) {
        ModelAndView modelAndView = new ModelAndView();
        List<Task> tasks = tasksForm.getTasks();

        try {
            if(null != tasks && tasks.size() > 0) {
                for (Task item : tasks) {
                    taskService.updateTask(item);
                }
            }

            // Load all tasks
            User user = WebSecurity.getCurrentUser();
            List<Task> tasksNew = taskService.getUserTasks(user);

            modelAndView.addObject("tasks", tasksNew);
            modelAndView.addObject("success", true);
        } catch (Exception ex) {
            modelAndView.addObject("success", false);
        }
        modelAndView.setViewName("allTasks");
        return modelAndView;
    }


    @RequestMapping(value = "{id}/actionTask", params = "updateTaskAction", method= RequestMethod.POST)
    public ModelAndView saveChangesNote(@PathVariable("id") Integer id,
                                        @RequestParam(value = "name") String name,
                                        @RequestParam(value = "prioritising") Integer priority,
                                        @RequestParam(value = "isDone", required=false) Boolean isDoneTask,
                                        @RequestParam(value = "taskType") String type,
                                        @RequestParam(value = "body") String text,
                                        @RequestParam(value = "dateCreate") Date dateStart,
                                        @RequestParam(value = "dateDeadLine") Date dateEnd) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            TaskType typeTask = taskTypeService.getTypeByName(type);
            User user = WebSecurity.getCurrentUser();

            Task task = new Task();
            task.setId((long)id);
            task.setName(name);
            task.setPrioritising(priority);
            task.setTaskType(typeTask);
            task.setBody(text);
            task.setDateCreate(dateStart);
            task.setDateDeadLine(dateEnd);
            task.setUser(user);

            boolean done = (isDoneTask == null) ? false : isDoneTask;
            task.setIsDone(done);

            try {
                taskService.updateTask(task);
            } catch (Exception ex) {
                view.addObject("success", false);
                return new ModelAndView("redirect:/error/notfound?place=Note Control&&traceError=" + ex.getMessage());
            }
            return new ModelAndView("redirect:/task/all");
        }
        catch (Exception ex) {
            view.addObject("success", false);
            return new ModelAndView("redirect:/error/notfound?place=Note Control&&traceError=" + ex.getMessage());
        }
    }

    @RequestMapping(value = "{id}/actionTask", params = "deleteTaskAction", method= RequestMethod.POST)
    public ModelAndView deleteNote(@PathVariable("id") Integer id) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            try {
                taskService.deleteTask(id);
            } catch (Exception ex) {
                view.addObject("success", false);
                return new ModelAndView("redirect:/error/notfound?place=Note Control&&traceError=" + ex.getMessage());
            }

            return new ModelAndView("redirect:/task/all");
        }
        catch (Exception ex) {
            view.addObject("success", false);
            return new ModelAndView("redirect:/error/notfound?place=Note Control&&traceError=" + ex.getMessage());
        }
    }
}
