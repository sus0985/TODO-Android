package com.example.todo.repository

import com.example.todo.database.CategoryDao
import com.example.todo.model.Category

class LocalDataSource(private val categoryDao: CategoryDao)  {

    suspend fun loadAllCategoryOrNull() = categoryDao.loadAllCategoryOrNull()

    suspend fun insertCategory(category: Category) = categoryDao.insertCategory(category)

    suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }

    suspend fun updateCategory(category: Category) {
        categoryDao.updateCategory(category)
    }
}
