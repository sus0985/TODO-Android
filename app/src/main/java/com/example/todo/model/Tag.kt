package com.example.todo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TAG")
data class Tag(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "text") val text: String
)
