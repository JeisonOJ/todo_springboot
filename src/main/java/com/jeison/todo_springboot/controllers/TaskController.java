package com.jeison.todo_springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jeison.todo_springboot.models.Task;
import com.jeison.todo_springboot.services.TaskService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping({ "", "/" })
    public String showAllTasks(Model model) {

        model.addAttribute("title", "TO DO - Tasks");
        model.addAttribute("tasks", taskService.findAll());

        return "viewTasks";
    }

    @GetMapping("form")
    public String formTask(Model model) {
        model.addAttribute("title", "TO DO - Create Task");
        model.addAttribute("task", new Task());
        model.addAttribute("action", "form/createTask");

        return "form";
    }

    @PostMapping("form/createTask")
    public String createTask(@ModelAttribute Task task) {
        taskService.insert(task);
        return "redirect:/";
    }

    @GetMapping("form/{id}")
    public String formTaskToUpdate(@PathVariable Long id,Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("title", "TO DO - Update Task");
        model.addAttribute("task", task);
        model.addAttribute("action", "/form/updateTask/"+id);

        return "form";
    }

    @PostMapping("/form/updateTask/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        taskService.update(id,task);
        return "redirect:/";
    }

    @GetMapping("/form/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        
        taskService.delete(id);

        return "redirect:/";
    }

}
