package com.example.simpletodo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo_table")
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    var key: Long,

    @ColumnInfo(name = "task")
    var task: String
)