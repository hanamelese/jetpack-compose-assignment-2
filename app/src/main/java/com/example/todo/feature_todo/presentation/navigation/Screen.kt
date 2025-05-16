package com.example.todo.feature_todo.presentation.navigation

sealed class Screen(val route: String) {
    object TodoListScreen : Screen("todo_list_screen")
    object TodoDetailScreen : Screen("todo_detail_screen/{todoId}") {
        fun createRoute(todoId: Int) = "todo_detail_screen/$todoId"
    }
}
