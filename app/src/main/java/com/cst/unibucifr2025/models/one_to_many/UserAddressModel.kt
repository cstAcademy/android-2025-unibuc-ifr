package com.cst.unibucifr2025.models.one_to_many

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserAddressModel (
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: String,
    val street: String,
    val streetNumber: Int
) {
    companion object {
        const val ID = "id"
    }
}