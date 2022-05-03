package com.commonsware.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_roster.*

class MainActivity : AppCompatActivity() {
  lateinit var todoListRecyclerView: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.todo_roster)

    todoListRecyclerView = findViewById(R.id.lists_recyclerview)
    todoListRecyclerView.layoutManager = LinearLayoutManager(this)
    todoListRecyclerView.adapter = TodoListAdapter()

    fab.setOnClickListener { _ ->
      showCreateTodoListDialog()
    }
  }

  private fun showCreateTodoListDialog() {
    val positiveBtnTitle = getString(R.string.create_list)
    val myDialog = AlertDialog.Builder(this)
    val todoListEditText = EditText(this)
    todoListEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
    myDialog.setTitle(getString(R.string.name_of_list))
    myDialog.setView(todoListEditText)
    myDialog.setPositiveButton(positiveBtnTitle) {
      dialog, _ ->
      val adapter = todoListRecyclerView.adapter as TodoListAdapter
      adapter.addNewItem(todoListEditText.text.toString())
      dialog.dismiss()
    }
    myDialog.create().show()
  }
}