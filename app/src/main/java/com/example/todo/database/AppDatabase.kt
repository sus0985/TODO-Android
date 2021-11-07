package com.example.todo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todo.model.Category

@Database(entities = [Category::class], version = 1)
@TypeConverters(ColorConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}
