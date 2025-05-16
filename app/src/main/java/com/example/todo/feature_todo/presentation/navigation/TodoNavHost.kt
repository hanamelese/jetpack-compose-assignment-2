package com.example.todo.feature_todo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todo.feature_todo.presentation.screens.TodoListScreen
import com.example.todo.feature_todo.presentation.screens.TodoDetailScreen

@Composable
fun TodoNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = Screen.TodoListScreen.route, modifier = modifier) {
        composable(Screen.TodoListScreen.route) {
            TodoListScreen(viewModel = hiltViewModel(), navController = navController)
        }
        composable(
            route = Screen.TodoDetailScreen.route,
            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val todoId = backStackEntry.arguments?.getInt("todoId") ?: 0
            TodoDetailScreen(
                viewModel = hiltViewModel(),
                navController = navController,
                todoId = todoId
            )
        }

    }
}