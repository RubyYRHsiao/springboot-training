package com.example.training.controller;

import com.example.training.entity.Task;
import com.example.training.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        path = {"api/v1/task"}
)
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") Long id){
        return taskService.findTaskById(id);
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteByTaskId(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
