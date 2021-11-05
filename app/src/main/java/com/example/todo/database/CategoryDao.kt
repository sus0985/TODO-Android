package com.example.todo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.todo.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * from CATEGORY")
    suspend fun getAllTagOrNull(): List<Category>

    @Insert(onConflict = REPLACE)
    suspend fun insertTag(category: Category)
}
