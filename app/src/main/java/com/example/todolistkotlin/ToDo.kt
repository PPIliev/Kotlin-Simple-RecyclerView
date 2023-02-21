package com.example.todolistkotlin

data class ToDo(
    val title: String,
    var isChecked: Boolean = false
)