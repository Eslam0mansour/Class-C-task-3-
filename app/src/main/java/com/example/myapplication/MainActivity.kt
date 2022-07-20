package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todolistsingleitem = mutableListOf(Todo(title = "go to gym " , ischecked = true))
        val  adapter = TodoAdapter(todolistsingleitem)
        binding.rvtoodos.adapter = adapter
        binding.rvtoodos.layoutManager = LinearLayoutManager(this)

        binding.btnaddtodo.setOnClickListener {
           val newTodoTitle =  binding.etaddtodo.text.toString()
           val newTodo = Todo( newTodoTitle , false)
            todolistsingleitem.add(newTodo)
            binding.etaddtodo.text.clear()
            adapter.notifyDataSetChanged()

        }

    }
}