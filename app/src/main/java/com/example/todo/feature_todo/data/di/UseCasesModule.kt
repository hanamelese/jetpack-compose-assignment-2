package com.example.todo.feature_todo.data.di


import com.example.todo.feature_todo.domain.repo.TodoListRepo
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideTodoUseCases(repo: TodoListRepo): TodoUseCases {
        return TodoUseCases(repo)
    }
}