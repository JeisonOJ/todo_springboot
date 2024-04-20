package com.jeison.todo_springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jeison.todo_springboot.services.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public String showAllTasks(Model model) {

        model.addAttribute("title", "TO DO - Tasks");
        model.addAttribute("tasks", taskService.findAll());

        return "viewTasks";
    }

}
