package com.example.java_spring_hw.service;

import com.example.java_spring_hw.entity.Task;
import com.example.java_spring_hw.request.TaskRequest;

import java.util.List;

public interface TaskService {
    Task create(TaskRequest request);

    List<Task> getAll();

    Task get(long id);

    void startTask(long id);
}
