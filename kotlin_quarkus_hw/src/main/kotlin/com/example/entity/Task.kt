package com.example.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "tasks")
@Entity
data class Task(
    @Id
    @GeneratedValue
    val id: Long? = null,

    val createdAt: Date? = null,

    val isStarted: Boolean = false,

    val dsc: String? = null
)