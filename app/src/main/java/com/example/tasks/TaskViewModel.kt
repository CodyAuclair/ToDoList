package com.example.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {
    val allTasks: LiveData<List<TaskModel>> = repository.allTasks

    fun insert(taskModel: TaskModel) = viewModelScope.launch {
        repository.insert(taskModel)
    }

    fun delete(taskModel: TaskModel) = viewModelScope.launch {
        repository.delete(taskModel)
    }

}