package com.example.todo.repository

import com.example.todo.model.Category

interface HomeRepository {

    suspend fun getAllTagOrNull(): List<Category>?
}
