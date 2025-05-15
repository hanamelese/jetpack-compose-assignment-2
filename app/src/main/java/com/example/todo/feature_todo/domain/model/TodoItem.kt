package com.example.todo.feature_todo.domain.model

data class TodoItem(
    val userId: Int,
    val title:String,
    val completed:Boolean,
    val id:Int?,
)
