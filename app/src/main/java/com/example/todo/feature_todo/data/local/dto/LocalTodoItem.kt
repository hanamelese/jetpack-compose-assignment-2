package com.example.todo.feature_todo.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class LocalTodoItem(
    val userId: Int,
    val title:String,
    val completed:Boolean,
    @PrimaryKey(autoGenerate = true)
    val id:Int?,

)
