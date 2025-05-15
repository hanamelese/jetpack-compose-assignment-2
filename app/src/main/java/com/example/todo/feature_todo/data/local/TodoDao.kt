package com.example.todo.feature_todo.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todo.feature_todo.data.local.dto.LocalTodoItem

interface TodoDao {
    @Query("Select * from todo")
    fun getAllTodoItems():List<LocalTodoItem>

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getSingleTodoItemById(id: Int): LocalTodoItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllTodoItems(items: List<LocalTodoItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodoItem(item: LocalTodoItem): Long
}