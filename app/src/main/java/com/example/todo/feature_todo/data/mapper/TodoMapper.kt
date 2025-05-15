package com.example.todo.feature_todo.data.mapper

import com.example.todo.feature_todo.data.local.dto.LocalTodoItem
import com.example.todo.feature_todo.data.remote.dto.RemoteTodoItem
import com.example.todo.feature_todo.domain.model.TodoItem

fun TodoItem.toLocalTodoItem():LocalTodoItem{
    return LocalTodoItem(
        title=title,
        completed = completed,
        id = id,
        userId = userId
    )
}

fun TodoItem.toRemoteTodoItem():RemoteTodoItem{
    return RemoteTodoItem(
        title=title,
        completed = completed,
        id = id,
        userId = userId
    )
}

fun LocalTodoItem.toRemoteTodoItem():RemoteTodoItem{
    return RemoteTodoItem(
        title=title,
        completed = completed,
        id = id,
        userId = userId
    )
}

fun LocalTodoItem.toTodoItem():TodoItem{
    return TodoItem(
        title=title,
        completed = completed,
        id = id,
        userId = userId
    )
}

fun RemoteTodoItem.toTodoItem():TodoItem{
    return TodoItem(
        title=title,
        completed = completed,
        id = id,
        userId = userId
    )
}

fun RemoteTodoItem.toLocalTodoItem():LocalTodoItem{
    return LocalTodoItem(
        title=title,
        completed = completed,
        id = id,
        userId = userId
    )
}





fun List<TodoItem>.toLocalTodoItemList():List<LocalTodoItem>{
    return this
        .map { todo-> LocalTodoItem(
            title=todo.title,
            completed = todo.completed,
            id = todo.id,
            userId = todo.userId
        ) }
}

fun List<TodoItem>.toRemoteTodoItemList():List<RemoteTodoItem>{
    return this
        .map { todo-> RemoteTodoItem(
            title=todo.title,
            completed = todo.completed,
            id = todo.id,
            userId = todo.userId
        ) }
}

fun List<LocalTodoItem>.toTodoItemListFromLocal():List<TodoItem>{
    return this
        .map { todo-> TodoItem(
            title=todo.title,
            completed = todo.completed,
            id = todo.id,
            userId = todo.userId
        ) }
}

fun List<LocalTodoItem>.toRemoteTodoItemListFromLocal():List<RemoteTodoItem>{
    return this
        .map { todo-> RemoteTodoItem(
            title=todo.title,
            completed = todo.completed,
            id = todo.id,
            userId = todo.userId
        ) }
}

fun List<RemoteTodoItem>.toTodoItemListFromRemote():List<TodoItem>{
    return this
        .map { todo-> TodoItem(
            title=todo.title,
            completed = todo.completed,
            id = todo.id,
            userId = todo.userId
        ) }
}

fun List<RemoteTodoItem>.toLocalTodoItemListFromRemote():List<LocalTodoItem>{
    return this
        .map { todo-> LocalTodoItem(
            title=todo.title,
            completed = todo.completed,
            id = todo.id,
            userId = todo.userId
        ) }
}