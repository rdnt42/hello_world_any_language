package com.example.controller

import com.example.entity.Task
import com.example.request.TaskRequest
import com.example.service.TaskService
import javax.ws.rs.*

@Path("/api/tasks")
class TaskController(
    private val taskService: TaskService
) {

    @POST
    fun create(request: TaskRequest): Task {
        return taskService.create(request)
    }

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: Long): Task {
        return taskService.get(id)
    }

    @GET
    fun getAll(): List<Task> {
        return taskService.getAll()
    }

}