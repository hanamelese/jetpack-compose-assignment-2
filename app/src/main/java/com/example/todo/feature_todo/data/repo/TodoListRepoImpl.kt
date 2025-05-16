package com.example.todo.feature_todo.data.repo

import android.util.Log
import coil.network.HttpException
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.data.local.TodoDao
import com.example.todo.feature_todo.data.mapper.toLocalTodoItemListFromRemote
import com.example.todo.feature_todo.data.mapper.toTodoItem
import com.example.todo.feature_todo.data.mapper.toTodoItemListFromLocal
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.TodoListRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.net.UnknownHostException

class TodoListRepoImpl(
    private val dao: TodoDao,
    private val api:TodoApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
):TodoListRepo {
    override suspend fun getAllTodo(): List<TodoItem> {
        getAllTodosFromRemote()
        return dao.getAllTodoItems().toTodoItemListFromLocal()
    }

    override suspend fun getAllTodosFromLocal(): List<TodoItem> {
        return dao.getAllTodoItems().toTodoItemListFromLocal()
    }

    override suspend fun getAllTodosFromRemote() {
        withContext(dispatcher) {
            try {
                refreshRoomCache()
            } catch (e: Exception) {
                when (e) {
                    is UnknownHostException, is ConnectException, is HttpException -> {
                        Log.e("HTTP", "Error: No data from the remote")
                        if (isCacheEmpty()) {
                            Log.e("Cache", "Error: No data from local Room cache")
                            throw Exception("Error: Device offline and no data from Room cache")
                        }
                    }
                    else -> throw e
                }
            }
        }
    }

    private suspend fun refreshRoomCache() {
        val remoteItems = api.getAllTodos().filterNotNull()
        Log.d("RemoteFetch", "Fetched ${remoteItems.size} items from API")
        dao.addAllTodoItems(remoteItems.toLocalTodoItemListFromRemote())
    }


    private suspend fun isCacheEmpty(): Boolean {
        return dao.getAllTodoItems().isEmpty()
    }




    override suspend fun getSingleTodoItemById(id: Int): TodoItem? {
        return dao.getSingleTodoItemById(id)?.toTodoItem()
    }
}

