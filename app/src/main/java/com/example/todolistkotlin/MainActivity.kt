package com.example.todolistkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        val toDoAdapter = ToDoAdapter(mutableListOf())
        binding.rvToDoList.adapter = toDoAdapter
        binding.rvToDoList.layoutManager = LinearLayoutManager(this)

        // Set up the button click listeners
        binding.bAdd.setOnClickListener {
            val toDoTitle = binding.etAddItem.text.toString()
            if (toDoTitle.isNotEmpty()) {
                val todo = ToDo(toDoTitle)
                toDoAdapter.addToDo(todo)
                binding.etAddItem.text.clear()
            }
        }

        binding.bDelete.setOnClickListener {
            toDoAdapter.deleteDoneToDos()
        }
    }
}