package com.example.training.service;

import com.example.training.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> findTaskById(Long id);
    Task saveTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Long id);
}
