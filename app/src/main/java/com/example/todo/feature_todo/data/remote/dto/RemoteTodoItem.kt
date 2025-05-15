package com.example.todo.feature_todo.data.remote.dto

import androidx.room.PrimaryKey

data class RemoteTodoItem(
    val userId: Int,
    val title:String,
    val completed:Boolean,
    val id:Int?,
)
