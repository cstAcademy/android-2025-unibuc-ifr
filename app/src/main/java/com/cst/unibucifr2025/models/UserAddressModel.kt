package com.cst.unibucifr2025.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserAddressModel (
    @PrimaryKey
    val id: String,
    val street: String,
    val streetNumber: Int
)