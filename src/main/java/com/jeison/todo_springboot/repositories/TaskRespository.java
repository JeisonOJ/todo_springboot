package com.jeison.todo_springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeison.todo_springboot.models.Task;

@Repository
public interface TaskRespository extends JpaRepository<Task,Long>{

    public List<Task> findByTitle(String name);

    public List<Task> findByTitleContaining(String name);
    public List<Task> findByStatus(String status);
    public List<Task> findByTitleContainingAndStatusContaining(String title, String status);

}
