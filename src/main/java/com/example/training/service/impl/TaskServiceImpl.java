package com.example.training.service.impl;

import com.example.training.dao.TaskDao;
import com.example.training.entity.Task;
import com.example.training.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao taskDao;

    @Override
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }
}
