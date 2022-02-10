package com.example.simpletodo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simpletodo.dao.TaskDao
import com.example.simpletodo.models.TaskModel

@Database(entities = [TaskModel::class], version = 1,exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    companion object {
        private const val DB_NAME = "todo_table"
        var instance: ToDoDatabase? = null

        fun getInstance(context: Context): ToDoDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, ToDoDatabase::class.java, DB_NAME)

                    .allowMainThreadQueries()
                    .build()
            }
            return instance as ToDoDatabase
        }
    }

    abstract fun taskDao(): TaskDao
}