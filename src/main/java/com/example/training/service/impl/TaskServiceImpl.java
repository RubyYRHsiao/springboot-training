package com.example.training.service.impl;

import com.example.training.entity.Task;
import com.example.training.repository.TaskRepository;
import com.example.training.service.TaskService;
import com.example.training.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public ResponseVO<List<Task>> getAllTasks() {
        return ResponseVO.<List<Task>>builder().result(taskRepository.findAll()).build();
    }

    @Override
    public ResponseVO<Optional<Task>> findTaskById(Long id) {
        Optional<Task> data = taskRepository.findById(id);
        if (!data.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task does not exists");
        return ResponseVO.<Optional<Task>>builder().result(data).build();
    }

    @Override
    public ResponseVO<Task> saveTask(Task task) {
        return ResponseVO.<Task>builder().result(taskRepository.save(task)).build();
    }

    @Override
    public ResponseVO<Task> updateTask(Task task) {
        Optional<Task> data = taskRepository.findById(task.getId());
        if (!data.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task does not exists");
        return ResponseVO.<Task>builder().result(taskRepository.save(task)).build();
    }

    @Override
    public ResponseVO<String> deleteTask(Long id) {
        Optional<Task> data = taskRepository.findById(id);
        if (!data.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task does not exists");
        taskRepository.deleteById(id);
        return ResponseVO.<String>builder().message("success").build();
    }
}
