package com.example.todoapp.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/todoapp/ui/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "todoDataSource", "Lcom/example/todoapp/data/room/TodoDataSource;", "(Lcom/example/todoapp/data/room/TodoDataSource;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/todoapp/ui/theme/HomeViewState;", "selected", "", "state", "getState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "todoList", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/todoapp/data/Todo;", "deleteTodo", "Lkotlinx/coroutines/Job;", "todo", "onTaskCompleted", "Landroidx/compose/ui/text/style/TextDecoration;", "updateTodo", "id", "", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.todoapp.data.room.TodoDataSource todoDataSource = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.todoapp.ui.theme.HomeViewState> _state = null;
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.todoapp.data.Todo>> todoList = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> selected = null;
    
    public HomeViewModel() {
        super();
    }
    
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.example.todoapp.data.room.TodoDataSource todoDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.example.todoapp.ui.theme.HomeViewState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateTodo(boolean selected, long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.ui.text.style.TextDecoration onTaskCompleted(@org.jetbrains.annotations.NotNull()
    com.example.todoapp.data.Todo todo) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteTodo(@org.jetbrains.annotations.NotNull()
    com.example.todoapp.data.Todo todo) {
        return null;
    }
}