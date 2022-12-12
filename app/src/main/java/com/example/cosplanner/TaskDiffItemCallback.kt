package com.example.cosplanner

import androidx.recyclerview.widget.DiffUtil
class TaskDiffItemCallback : DiffUtil.ItemCallback<ToDo>() {
    override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo) = (oldItem.taskId == newItem.taskId)
    override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo) = (oldItem == newItem)
}