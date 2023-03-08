package com.example.training.service.impl;

import com.example.training.repository.TaskRepository;
import com.example.training.entity.Task;
import com.example.training.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        Optional<Task> data = taskRepository.findById(id);
        if (!data.isPresent())
            throw new IllegalStateException("Task does not exists");
        return taskRepository.findById(id);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        Optional<Task> data = taskRepository.findById(task.getId());
        if (!data.isPresent())
            throw new IllegalStateException("Task does not exists");
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        Optional<Task> data = taskRepository.findById(id);
        if (!data.isPresent())
            throw new IllegalStateException("Task does not exists");
        taskRepository.deleteById(id);
    }
}
