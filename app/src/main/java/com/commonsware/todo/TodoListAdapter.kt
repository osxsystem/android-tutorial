package com.commonsware.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter: RecyclerView.Adapter<TodoListViewHolder>() {
  private var todoList : MutableList<String> = mutableListOf("Android Development", "House Work", "Errands", "Foo", "Bar")

  fun addNewItem(item: String) {
    todoList.add(item)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_list_view_holder, parent, false)
    return TodoListViewHolder(view)
  }

  override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
    holder.listPositionTextView.text = (position + 1).toString()
    holder.listTitleTextView.text = todoList[position]
  }

  override fun getItemCount(): Int {
    return todoList.count()
  }
}