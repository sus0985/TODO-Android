package com.example.todo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.todo.model.Tag

@Dao
interface TagDao {

    @Query("SELECT * from TAG")
    suspend fun getAllTagOrNull(): List<Tag>

    @Insert(onConflict = REPLACE)
    suspend fun insertTag(tag: Tag)
}
