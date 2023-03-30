package com.example.training.service;

import com.example.training.entity.Task;
import com.example.training.vo.ResponseVO;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    ResponseVO<List<Task>> getAllTasks();

    ResponseVO<Optional<Task>> findTaskById(Long id);

    ResponseVO<Task> saveTask(Task task);

    ResponseVO<Task> updateTask(Task task);

    ResponseVO<String> deleteTask(Long id);
}
