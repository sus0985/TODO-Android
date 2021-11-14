package com.example.todo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CATEGORY")
data class Category(
    @ColumnInfo(name = "text") var text: String,
    @ColumnInfo(name = "color") var color: ColorCode,
    @ColumnInfo(name = "task_count") val taskCount: Int
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
