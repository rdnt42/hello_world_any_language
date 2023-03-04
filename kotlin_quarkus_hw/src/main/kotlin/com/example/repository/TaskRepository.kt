package com.example.repository

import com.example.entity.Task
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TaskRepository : PanacheRepository<Task> {
}