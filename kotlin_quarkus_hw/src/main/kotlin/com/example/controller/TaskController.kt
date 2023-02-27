package com.example.controller

import com.example.entity.Task
import com.example.request.TaskRequest
import com.example.service.TaskService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/api/tasks")
class TaskController(
    private val taskService: TaskService
) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun create(request: TaskRequest): Task {
        return taskService.create(request)
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    fun getById(@PathParam("id") id: Long): Task {
        return taskService.get(id)
    }

}