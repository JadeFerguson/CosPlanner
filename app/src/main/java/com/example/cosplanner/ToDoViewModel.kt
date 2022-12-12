package com.example.cosplanner

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ToDoViewModel(val dao: ToDoDao) : ViewModel() {
    var newTaskName = ""

    private val tasks = dao.getAll()
    val tasksString = Transformations.map(tasks) {
            tasks -> formatTasks(tasks)
    }

    fun addTask() {
        viewModelScope.launch {
            val task = ToDo()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }
    fun formatTasks(tasks: List<ToDo>): String {
        return tasks.fold("") {
                str, item -> str + '\n' + formatTask(item)
        }
    }
    fun formatTask(task: ToDo): String {
        var str = "ID: ${task.taskId}"
        str += '\n' + "Name: ${task.taskName}"
        str += '\n' + "Complete: ${task.taskDone}" + '\n'
        return str
    }
}