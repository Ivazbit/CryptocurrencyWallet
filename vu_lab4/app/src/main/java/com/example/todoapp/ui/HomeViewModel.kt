package com.example.todoapp.ui

import androidx.compose.ui.text.style.TextDecoration
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.Graph
import com.example.todoapp.data.Todo
import com.example.todoapp.data.room.TodoDataSource
import com.example.todoapp.ui.theme.HomeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class HomeViewModel(private val todoDataSource: TodoDataSource = Graph.todoRepo) : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state : MutableStateFlow<HomeViewState>
        get() = _state

    private val todoList = todoDataSource.selectAll
    //var searchValue = MutableStateFlow(state.value.searchValue)
    private val selected = MutableStateFlow(_state.value.selected)

    init {
        viewModelScope.launch {
            combine(todoList,selected){ todoList, selected ->
                HomeViewState(todoList, selected)
            }.collect {
                _state.value = it
            }
        }
    }

    //Events
    fun updateTodo(selected: Boolean, id: Long) = viewModelScope.launch {
        todoDataSource.updateTodo(selected, id)
    }

    fun onTaskCompleted(todo: Todo): TextDecoration {
        return if (todo.isCompleted) {
            TextDecoration.LineThrough
        } else {
            TextDecoration.None
        }
    }

//    fun onSearchTextChanged(searchValue: String): HomeViewState {
//        HomeViewState().copy(searchValue = searchValue)
//        return state.value.copy(searchValue = searchValue)
//    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch {
        todoDataSource.deleteTodo(todo)
    }
}

