package com.example.service

import com.example.entity.Task
import com.example.repository.TaskRepository
import com.example.request.TaskRequest
import org.jboss.logging.Logger
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import kotlin.random.Random


@Singleton
class TaskService(
) {

    @Inject
    lateinit var taskRepository: TaskRepository
    var LOG = Logger.getLogger(TaskService::class.java)


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

    fun startTask(id: Long) {
        val task: Task = taskRepository.findById(id)

        val isFailed: Boolean = Random.nextBoolean()
        if (isFailed) {
            LOG.error("Runtime error for task: $id")
            throw Exception("Runtime error for task: $id")
        }

    }

}