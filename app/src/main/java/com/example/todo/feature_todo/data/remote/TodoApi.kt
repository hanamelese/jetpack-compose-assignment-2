package com.example.todo.feature_todo.data.remote

import com.example.todo.feature_todo.data.remote.dto.RemoteTodoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface TodoApi {
    @GET("todo")
    suspend fun getAllTodos():List<RemoteTodoItem>
    @GET("todo/{id}")
    suspend fun getSingleTodoById(@Path("id") id: Int):RemoteTodoItem

}