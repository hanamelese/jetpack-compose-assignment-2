package com.example.todo.feature_todo.domain.repo

import com.example.todo.feature_todo.domain.model.TodoItem

interface TodoListRepo {
    suspend fun getAllTodo():List <TodoItem>
    suspend fun getAllTodosFromLocal():List <TodoItem>
    suspend fun getAllTodosFromRemote()
    suspend fun getSingleTodoItemById(id: Int): TodoItem?

}



