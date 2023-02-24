package com.example.java_spring_hw.controller;

import com.example.java_spring_hw.entity.Task;
import com.example.java_spring_hw.request.TaskRequest;
import com.example.java_spring_hw.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/tasks")
@RestController
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Task create(@RequestBody TaskRequest request) {
        return taskService.create(request);
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable long id) {
        return taskService.get(id);
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}/start")
    public void startTask(@PathVariable long id) {
        taskService.startTask(id);
    }
}
