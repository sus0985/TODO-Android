package com.example.todo.database

import androidx.room.TypeConverter
import com.example.todo.model.ColorCode

class ColorConverter {
    @TypeConverter
    fun fromColor(value: ColorCode): Int = value.ordinal

    @TypeConverter
    fun toColor(value: Int): ColorCode = when (value) {
        0 -> ColorCode.BLACK
        1 -> ColorCode.LIGHT_YELLOW
        2 -> ColorCode.LIGHT_BLUE
        3 -> ColorCode.DARK_BLUE
        4 -> ColorCode.DARK_GREEN
        5 -> ColorCode.DARK_RED
        6 -> ColorCode.PINK
        else -> ColorCode.CHOCOLATE
    }
}
