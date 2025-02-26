package com.example.tasks

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<TaskModel>> = taskDao.getAllTasks()

    suspend fun insert(taskModel: TaskModel) {
        taskDao.insert(taskModel)
    }

    suspend fun delete(taskModel: TaskModel) {
        taskDao.delete(taskModel)
    }
}