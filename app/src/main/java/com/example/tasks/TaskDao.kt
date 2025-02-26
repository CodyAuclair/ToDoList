package com.example.tasks

import androidx.lifecycle.LiveData

interface TaskDao {
    fun getAllTasks(): LiveData<List<TaskModel>>

    suspend fun insert(taskModel: TaskModel)

    suspend fun delete(taskModel: TaskModel)
}