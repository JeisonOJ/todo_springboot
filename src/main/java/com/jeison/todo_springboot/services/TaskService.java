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

    public List<Task> findAll(){
        return taskRespository.findAll();
    }

}
