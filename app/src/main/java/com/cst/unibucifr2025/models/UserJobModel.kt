package com.cst.unibucifr2025.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserJobModel(
    @PrimaryKey
    val id: String,
    val company: String
)