package com.example.service

import com.example.entity.Task
import com.example.request.TaskRequest
import javax.inject.Singleton
import javax.persistence.EntityManager

@Singleton
class TaskService(
    private val entityManager: EntityManager
) {


    fun create(request: TaskRequest): Task {
        val task = Task(dsc = request.dsc)

        entityManager.persist(task)

        return task
    }

    fun get(id: Long): Task {
        return entityManager.find(Task::class.java, id)
    }

}