package com.example.cosplanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ToDoViewModel(val dao: ToDoDao) : ViewModel() {
    var newTaskName = ""
    val tasks = dao.getAll()

    fun addTask() {
        viewModelScope.launch {
            val task = ToDo()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }

}