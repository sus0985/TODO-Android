package com.example.todo.repository

import com.example.todo.database.CategoryDao

class LocalDataSource(private val categoryDao: CategoryDao)  {

    suspend fun getAllTagOrNull() = categoryDao.getAllTagOrNull()
}
