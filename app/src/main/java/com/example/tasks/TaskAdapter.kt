package com.example.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R

class TaskAdapter(private val onDeleteClick: (TaskModel) -> Unit) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var taskModelList: List<TaskModel> = emptyList()

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.taskTitle)
        val checkBox: CheckBox = itemView.findViewById(R.id.taskCheckbox)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskModelList[position]
        holder.title.text = task.title
        holder.checkBox.isChecked = task.isCompleted
        holder.deleteButton.setOnClickListener { onDeleteClick(task) }
    }

    override fun getItemCount(): Int {
        return taskModelList.size
    }

    fun setTasks(taskModels: List<TaskModel>) {
        this.taskModelList = taskModels
        notifyDataSetChanged()
    }
}