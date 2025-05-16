package com.example.todo.feature_todo.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases
) : ViewModel() {

    private val _todoList = MutableStateFlow<List<TodoItem>>(emptyList())
    val todoList: StateFlow<List<TodoItem>> = _todoList

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

//    init {
//        viewModelScope.launch {
//            delay(300)
//            fetchTodoItems()
//        }
//    }

    fun fetchTodoItems() {
        viewModelScope.launch {
            when (val result = todoUseCases.getTodoItem()) {
                is TodoUseCases.TodoUseCasesResult.Success -> {
                    _todoList.value = result.items
                }
                is TodoUseCases.TodoUseCasesResult.Error -> {
                    _errorMessage.value = result.message
                }
            }
        }
    }

    suspend fun getTodoById(id: Int): TodoItem? {
        return todoUseCases.getSingleTodoItemById(id)
    }
}


//
//@HiltViewModel
//class TodoListViewModel @Inject constructor(
//    private val todoUseCases: TodoUseCases,
//    @IoDispatcher private val dispatcher: CoroutineDispatcher
//) : ViewModel() {
//
//    private val _state = mutableStateOf(TodoListState())
//    val state: State<TodoListState> = _state
//
//    init {
//        viewModelScope.launch {
//            delay(300) // 🔧 Slight delay to avoid startup ANR pressure
//            fetchTodoItems()
//        }
//    }
//
//    fun fetchTodoItems() {
//        viewModelScope.launch {
//            when (val result = todoUseCases.getTodoItem()) {
//                is Resource.Success -> {
//                    _state.value = state.value.copy(
//                        todoItems = result.data ?: emptyList()
//                    )
//                }
//                is Resource.Error -> {
//                    _state.value = state.value.copy(
//                        error = result.message ?: "Unexpected error occurred"
//                    )
//                }
//                is Resource.Loading -> {
//                    _state.value = state.value.copy(
//                        isLoading = true
//                    )
//                }
//            }
//        }
//    }
//
//    fun onEvent(event: TodoListEvent) {
//        when (event) {
//            is TodoListEvent.OnDeleteTodo -> {
//                viewModelScope.launch(dispatcher) {
//                    todoUseCases.deleteTodo(event.todo)
//                    fetchTodoItems()
//                }
//            }
//            TodoListEvent.OnGetAllTodos -> {
//                fetchTodoItems()
//            }
//        }
//    }
//}
