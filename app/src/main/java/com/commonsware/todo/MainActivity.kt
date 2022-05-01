package com.commonsware.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
  lateinit var todoListRecyclerView: RecyclerView
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.todo_roster)

    todoListRecyclerView = findViewById(R.id.lists_recyclerview)
    todoListRecyclerView.layoutManager = LinearLayoutManager(this)
    todoListRecyclerView.adapter = TodoListAdapter()
  }
}