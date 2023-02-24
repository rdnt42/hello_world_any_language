package com.example.java_spring_hw.service;

import com.example.java_spring_hw.entity.Task;
import com.example.java_spring_hw.repository.TaskRepository;
import com.example.java_spring_hw.request.TaskRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final Random random = new Random();
    private final TaskRepository taskRepository;

    @Override
    public Task create(TaskRequest request) {
        Task task = Task.builder()
                .dsc(request.getDsc())
                .build();

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task get(long id) {
        return taskRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public void startTask(long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow();

        boolean isFailed = random.nextBoolean();
        if (isFailed) {
            log.error("Runtime error for task: {}", id);
            throw new IllegalStateException("Runtime error for task: " + id);
        } else {
            startTask(task);
        }
    }

    private void startTask(Task task) {
        Runnable runnable = () -> {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            taskRepository.delete(task);
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
