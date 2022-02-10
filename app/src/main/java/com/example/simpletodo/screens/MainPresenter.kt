package com.example.simpletodo.screens

class MainPresenter : MainContract.Actions {

    private var _views: MainContract.Views? = null

    constructor(_views: MainContract.Views) {
        this._views = _views
        initScreens()
    }

    override fun initScreens() {
        _views?.setupViews()
        _views?.setupListeners()
        fetchAllTaskFromDatabase()
    }

    override fun addTaskToRecyclerView() {
        _views?.addTaskToRecyclerView(_views?.getTask()!!)

    }

    override fun addTaskToDatabase() {
        _views?.addTaskToDatabase(_views?.getTask()!!)
    }

    override fun fetchAllTaskFromDatabase() {
        _views?.addTaskToRecyclerViewList(_views?.getAllTaskFromDatabase() as ArrayList)
    }

}