package com.example.simpletodo.screens

import com.example.simpletodo.models.TaskModel

interface MainContract {

    interface Views {

        fun setupViews()
        fun setupListeners()
        fun getTask(): TaskModel
        fun addTaskToDatabase(item: TaskModel)
        fun deleteTaskFromDatabase(item: TaskModel)
        fun getAllTaskFromDatabase(): List<TaskModel>
        fun addTaskToRecyclerViewList(list: ArrayList<TaskModel>)
        fun addTaskToRecyclerView(item: TaskModel)
    }

    interface Actions {
        fun initScreens()
        fun addTaskToRecyclerView()
        fun addTaskToDatabase()
        fun fetchAllTaskFromDatabase()
    }
}