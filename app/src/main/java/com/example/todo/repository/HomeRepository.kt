package com.example.todo.repository

import com.example.todo.model.Tag

interface HomeRepository {

    suspend fun getAllTagOrNull(): List<Tag>?
}
