package com.cst.unibucifr2025.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityEntityModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String
)