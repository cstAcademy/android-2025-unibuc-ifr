package com.cst.unibucifr2025.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cst.unibucifr2025.models.DirectionType

@Entity
data class DirectionEntityModel (
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Long,
    val type: DirectionType
){
    companion object{
        const val ID = "id"
    }
}