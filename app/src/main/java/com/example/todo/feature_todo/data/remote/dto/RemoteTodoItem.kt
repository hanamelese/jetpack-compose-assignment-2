package com.example.todo.feature_todo.data.remote.dto


data class RemoteTodoItem(
    val userId:Int,
    val title:String,
    val completed:Boolean,
    val id:Int?,
)
