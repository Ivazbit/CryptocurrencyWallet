package com.example.todoapp.ui.theme

import com.example.todoapp.data.Todo

data class HomeViewState (
    val todoList: List<Todo> = emptyList(),
    val selected: Boolean = false
)