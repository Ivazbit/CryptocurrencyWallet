package com.example.todoapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.data.Todo

@Composable
fun HomeScreen(
    //onSearchTextChanged:(String) -> Unit,
    onNavigate:(Todo?) -> Unit
) {
    val viewModel = viewModel(HomeViewModel::class.java)
    val state by viewModel.state.collectAsState()


    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { onNavigate(null) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
    }) {
        LazyColumn() {
//            item {
//                TextField(
//                    value = state.searchValue,
//                    onValueChange = viewModel::onSearchTextChanged,
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    leadingIcon = {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_suche),
//                            contentDescription = null,
//                            modifier = Modifier.padding(end = 6.dp)
//                        )
//                    })
//            }

//            state.filteredTodoList.forEach { todo ->
//                item {
//                    TodoItem(
//                        todo = todo,
//                        onChecked = { viewModel.updateTodo(it, todo.id) },
//                        onDelete = { viewModel.deleteTodo(it) }
//                    )
//                }
                items(state.todoList){ todo ->
                    TodoItem(
                        todo = todo,
                        onChecked = { viewModel.updateTodo(it, todo.id) },
                        onDelete = { viewModel.deleteTodo(it) }
                    )
                }
            }
        }
}

@Composable
fun TodoItem(
    todo: Todo,
    //del situ pasiaiskint
    onChecked: (Boolean) -> Unit,
    onDelete: (Todo) -> Unit
) {
    val viewModel = viewModel(HomeViewModel::class.java)
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 4.dp, top = 4.dp, bottom = 4.dp)
        ) {
            Checkbox(
                checked = todo.isCompleted,
                onCheckedChange = { onChecked(it) },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = todo.todo,
                    style = MaterialTheme.typography.body2,
                    textDecoration = viewModel.onTaskCompleted(todo)
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = todo.description,
                        style = MaterialTheme.typography.body2,
                        textDecoration = viewModel.onTaskCompleted(todo)
                    )
                }
            }
            IconButton(onClick = { onDelete(todo) }) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "")
            }
        }
    }
}
//@Composable
//@Preview(showBackground = true)
//fun HomePreview(){
//    TodoAppTheme{
//        HomeScreen(onNavigate = )
//    }
//}
