package com.jeison.todo_springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeison.todo_springboot.models.Task;
import com.jeison.todo_springboot.repositories.TaskRespository;

@Service
public class TaskService {

    @Autowired
    private TaskRespository taskRespository;

    public List<Task> findAll() {
        return taskRespository.findAll();
    }

    public Task findById(Long id) {
        return taskRespository.findById(id).orElse(null);
    }

    public Task insert(Task task) {
        return taskRespository.save(task);
    }

    public Task update(Long id, Task task) {

        Task taskDB = findById(id);
        if (taskDB == null)
            return null;

        taskDB = task;
        return taskRespository.save(taskDB);
    }

    public void delete(Long id) {
        taskRespository.deleteById(id);
    }

}
