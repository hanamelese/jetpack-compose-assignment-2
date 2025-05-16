package com.example.todo.feature_todo.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.presentation.navigation.Screen
import com.example.todo.feature_todo.presentation.viewmodel.TodoViewModel

@Composable
fun TodoListScreen(viewModel: TodoViewModel, navController: NavController) {
    val todoList by viewModel.todoList.collectAsState()
    val error by viewModel.errorMessage.collectAsState()

    // Fetch data when screen is first shown
    LaunchedEffect(Unit) {
        viewModel.fetchTodoItems()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Todo Item List", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        if (error != null) {
            Text(text = "Error: $error", color = Color.Red)
        } else if (todoList.isEmpty()) {
            Text(text = "Loading...")
        } else {
            LazyColumn {
                items(todoList) { todo ->
                    todo.id?.let { id ->
                        TodoCard(todo = todo) {
                            navController.navigate(Screen.TodoDetailScreen.createRoute(id))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TodoCard(todo: TodoItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Blue)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = todo.title, style = MaterialTheme.typography.bodyLarge, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = if (todo.completed) "Completed" else "Not Completed",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
    }
}
