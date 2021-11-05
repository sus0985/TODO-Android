package com.example.todo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.model.Category

@Database(entities = [Category::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}
