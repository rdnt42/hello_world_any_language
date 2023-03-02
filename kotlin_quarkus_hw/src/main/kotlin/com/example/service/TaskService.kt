package com.example.service

import com.example.entity.Task
import com.example.request.TaskRequest
import repository.TaskRepository
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton
class TaskService(
) {

    @Inject
    lateinit var taskRepository: TaskRepository


    @Transactional
    fun create(request: TaskRequest): Task {
        val task = Task(dsc = request.dsc)

        taskRepository.persist(task)

        return task
    }

    fun get(id: Long): Task {
        return taskRepository.findById(id)
    }

    fun getAll(): List<Task> {
        return taskRepository.findAll().list()
    }

}