package com.example.todo.repository

import com.example.todo.database.TagDao

class LocalDataSource(private val tagDao: TagDao)  {

    suspend fun getAllTagOrNull() = tagDao.getAllTagOrNull()
}
