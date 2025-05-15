package com.example.todo.feature_todo.data.di

import android.content.Context
import androidx.room.Room
import com.example.todo.feature_todo.data.local.TodoDao
import com.example.todo.feature_todo.data.local.TodoDatabase
import com.example.todo.feature_todo.data.remote.TodoApi
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object TodoModule {

    @Provides
    fun providesRetrofitApi(retrofit: Retrofit):TodoApi{
        return retrofit.create(TodoApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
     return Retrofit.Builder()
         .addConverterFactory(
             GsonConverterFactory.create()
         ).baseUrl(" https://jsonplaceholder.typicode.com").build()
    }

    @Provides
    fun providesRoomDao(database: TodoDatabase): TodoDao {
        return database.dao
    }

    @Singleton
    @Provides
    fun providesRoomDb(
        @ApplicationContext appContext: Context
    ): TodoDatabase{
        return Room.databaseBuilder(
            appContext.applicationContext,
            TodoDatabase::class.java,
            "todo_database"
        ).fallbackToDestructiveMigration().build()
    }
}