package com.example.simpletodo.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.simpletodo.models.TaskModel
import kotlinx.coroutines.selects.select

@Dao
interface TaskDao {

    @Query("select * from todo_table")
    fun getAllDataFromDatabase():List<TaskModel>

    @Insert
    fun addTask(item:TaskModel)

    @Delete
    fun deleteTask(item: TaskModel)
}