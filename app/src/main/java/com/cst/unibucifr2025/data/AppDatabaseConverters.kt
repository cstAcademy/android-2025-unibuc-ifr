package com.cst.unibucifr2025.data

import androidx.room.TypeConverter
import com.cst.unibucifr2025.models.DirectionType

class AppDatabaseConverters {

    @TypeConverter
    fun directionTypeToInt(directionType: DirectionType): Int = directionType.id

    @TypeConverter
    fun intToDirectionType(id: Int): DirectionType = DirectionType.getDirectionTypeById(id)
}