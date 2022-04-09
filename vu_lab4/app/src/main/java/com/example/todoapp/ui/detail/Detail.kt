package com.example.todoapp.ui.detail

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.R
import com.example.todoapp.data.Todo

@Composable
fun DetailScreen(
    selectedId: Long,

    //jei () -> Unit tai gris i pradini ekrana
    onNavigate:() -> Unit
) {
    val viewModel = viewModel(
        DetailViewModel::class.java,
        factory = DetailViewModelFactory(selectedId)
    )
    val state by viewModel.state.collectAsState()
    DetailScreenComponent(
        todoText = state.todo,
        onTodoTextChange = {viewModel.onTextChange(it)},
        timeText = state.time,
        onTimeTextChange = {viewModel.onTimeChange(it)},
        onNavigate = { onNavigate() },
        onSaveTodo = {viewModel.insert(it)},
        selectedId = state.selectId,
        context = LocalContext.current
    )
}

@Composable
fun DetailScreenComponent(
    todoText: String,
    onTodoTextChange:(String) -> Unit,
    timeText: String,
    onTimeTextChange:(String) -> Unit,
    onNavigate: () -> Unit,
    onSaveTodo:(Todo) -> Unit,
    selectedId: Long,
    context: Context
){
    val isTodoEdit = selectedId == -1L
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            value = todoText,
            onValueChange = onTodoTextChange,
            label = {Text(text = stringResource(R.string.enter_task_name))}
        )

        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            value = timeText,
            onValueChange = onTimeTextChange,
            label = {Text(text = stringResource(R.string.enter_task_content))},

            )
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = {
            val todo = if (isTodoEdit) Todo(todoText, timeText, isCompleted = false)
            else Todo( todoText, timeText, false, id = selectedId)
            onSaveTodo(todo)
            onNavigate()
        }) {
            Text(text = stringResource(R.string.save))
        }
    }
}

