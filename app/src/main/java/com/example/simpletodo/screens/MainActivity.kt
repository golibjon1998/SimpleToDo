package com.example.simpletodo.screens

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpletodo.R
import com.example.simpletodo.adapter.ToDoAdapter
import com.example.simpletodo.db.ToDoDatabase
import com.example.simpletodo.listener.OnItemClicked
import com.example.simpletodo.models.TaskModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), MainContract.Views {

    lateinit var presenter: MainPresenter

    lateinit var mAdapter: ToDoAdapter

    lateinit var db: ToDoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = ToDoDatabase.getInstance(this)
        presenter = MainPresenter(this)
    }

    override fun setupViews() {
        mAdapter = ToDoAdapter(this, object : OnItemClicked {
            override fun onClick(position: Int) {
                db.taskDao().deleteTask(mAdapter.list[position])
                mAdapter.deleteItem(position)
            }

        })
        rv.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = mAdapter
        }
    }

    override fun setupListeners() {
        btn_send.setOnClickListener {
            val task = edt_write_task.text.toString()
            if (task == "") {
                Toast.makeText(this, "Write a text", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                presenter.addTaskToRecyclerView()
                presenter.addTaskToDatabase()
                edt_write_task.setText("")
            }
        }
    }

    override fun getTask(): TaskModel {
        return TaskModel(
            Random.nextLong(),
            edt_write_task.text.toString()
        )
    }

    override fun addTaskToDatabase(item: TaskModel) {
        db.taskDao().addTask(item)
    }

    override fun deleteTaskFromDatabase(item: TaskModel) {
        db.taskDao().deleteTask(item)
    }

    override fun getAllTaskFromDatabase(): List<TaskModel> {
        return db.taskDao().getAllDataFromDatabase()
    }

    override fun addTaskToRecyclerViewList(list: ArrayList<TaskModel>) {
        mAdapter.updateData(list)
    }

    override fun addTaskToRecyclerView(item: TaskModel) {
        mAdapter.addItem(item)
    }
}
