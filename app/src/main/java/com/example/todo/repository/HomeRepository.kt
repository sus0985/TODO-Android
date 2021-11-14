package com.example.todo.repository

import com.example.todo.model.Category

interface HomeRepository {

    suspend fun loadAllCategoryOrNull(): List<Category>?

    suspend fun insertCategory(category: Category)

    suspend fun deleteCategory(category: Category)

    suspend fun updateCategory(category: Category)
}
