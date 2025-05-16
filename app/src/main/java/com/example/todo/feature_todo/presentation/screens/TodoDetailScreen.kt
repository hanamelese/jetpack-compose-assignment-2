package com.example.todo.feature_todo.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.presentation.viewmodel.TodoViewModel


@Composable
fun TodoDetailScreen(viewModel: TodoViewModel, navController: NavController, todoId: Int) {
    val todoItem = remember { mutableStateOf<TodoItem?>(null) }

    LaunchedEffect(todoId) {
        todoItem.value = viewModel.getTodoById(todoId)
    }

    if (todoItem.value == null) {
        // Show loading before the item is retrieved
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        val todo = todoItem.value!!
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(text = "Title: ${todo.title}", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Id: ${todo.id}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "UserId: ${todo.userId}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = if (todo.completed) "Status: Completed" else "Status: Not Completed",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Back to Todo List")
            }
        }
    }
}
