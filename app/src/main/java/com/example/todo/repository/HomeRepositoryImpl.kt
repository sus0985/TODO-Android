package com.example.todo.repository

class HomeRepositoryImpl(private val localDataSource: LocalDataSource): HomeRepository {

    override suspend fun getAllTagOrNull() = localDataSource.getAllTagOrNull()
}
