package com.cst.unibucifr2025.models.one_to_one

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserIdentityCardModel(
    @PrimaryKey
    @ColumnInfo(name = OWNER_ID)
    val userOwnerId: String,
    val cnp: String
) {
    companion object {
        const val OWNER_ID = "ownerId"
    }
}