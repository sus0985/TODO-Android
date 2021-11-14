package com.example.todo.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.todo.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * from CATEGORY")
    suspend fun loadAllCategoryOrNull(): List<Category>

    @Insert(onConflict = REPLACE)
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)
}
