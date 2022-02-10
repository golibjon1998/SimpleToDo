package com.example.simpletodo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.R
import com.example.simpletodo.listener.OnItemClicked
import com.example.simpletodo.models.TaskModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.view.*

class ToDoAdapter(private val context: Context, var itemClicked: OnItemClicked) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    var list = arrayListOf<TaskModel>()

    fun updateData(items: ArrayList<TaskModel>) {
        this.list.clear()
        this.list.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: TaskModel) {
        list.add(item)
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ToDoViewHolder(view, itemClicked)

    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.itemView.item_task.text = list[position].task
    }


    class ToDoViewHolder(override val containerView: View, private val itemClicked: OnItemClicked)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            containerView.btn_cancel.setOnClickListener {
                itemClicked.onClick(adapterPosition)
            }
        }
    }
}
