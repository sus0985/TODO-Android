package com.example.todo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.todo.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * from CATEGORY")
    suspend fun loadAllCategoryOrNull(): List<Category>

    @Insert(onConflict = REPLACE)
    suspend fun insertCategory(category: Category)
}
