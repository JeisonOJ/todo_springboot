package com.jeison.todo_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeison.todo_springboot.models.Task;

@Repository
public interface TaskRespository extends JpaRepository<Task,Long>{

}
