package com.example.cosplanner

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface ToDoDao {
    @Insert
    fun insert(task: ToDo)
    @Update
    fun update(task: ToDo)
    @Delete
    fun delete(task: ToDo)
    @Query("SELECT * FROM task_table WHERE taskId = :taskId")
    fun get(taskId: Long): LiveData<ToDo>
    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
    fun getAll(): LiveData<List<ToDo>>
}