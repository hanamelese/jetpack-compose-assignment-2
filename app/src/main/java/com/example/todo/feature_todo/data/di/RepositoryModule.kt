package com.example.todo.feature_todo.data.di



import com.example.todo.feature_todo.data.repo.TodoListRepoImpl
import com.example.todo.feature_todo.domain.repo.TodoListRepo
import com.example.todo.feature_todo.data.local.TodoDao
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.data.di.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideTodoListRepo(
        dao: TodoDao,
        api: TodoApi,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): TodoListRepo {
        return TodoListRepoImpl(dao, api, dispatcher)
    }
}