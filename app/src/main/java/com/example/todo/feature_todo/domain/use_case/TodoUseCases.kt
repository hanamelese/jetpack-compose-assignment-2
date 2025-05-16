package com.example.todo.feature_todo.domain.use_case

import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.TodoListRepo
import dagger.Module
import javax.inject.Inject

class TodoUseCases @Inject constructor(
    private val repo:TodoListRepo
){
    suspend fun getSingleTodoItemById(id:Int):TodoItem?{
        return repo.getSingleTodoItemById(id)
    }





    suspend fun getTodoItem(

    ): TodoUseCasesResult {
        var items = repo.getAllTodosFromLocal()
        if (items.isEmpty()) {
            items = repo.getAllTodo()
        }
        return TodoUseCasesResult.Success(items)
}

    sealed class TodoUseCasesResult {
        data class Success(val items: List<TodoItem>) : TodoUseCasesResult()
        data class Error(val message: String) : TodoUseCasesResult()
    }}