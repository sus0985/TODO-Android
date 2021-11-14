package com.example.todo.repository

import com.example.todo.model.Category

class HomeRepositoryImpl(private val localDataSource: LocalDataSource): HomeRepository {

    override suspend fun loadAllCategoryOrNull() = localDataSource.loadAllCategoryOrNull()

    override suspend fun insertCategory(category: Category) {
        localDataSource.insertCategory(category)
    }

    override suspend fun deleteCategory(category: Category) {
        localDataSource.deleteCategory(category)
    }

    override suspend fun updateCategory(category: Category) {
        localDataSource.updateCategory(category)
    }
}
