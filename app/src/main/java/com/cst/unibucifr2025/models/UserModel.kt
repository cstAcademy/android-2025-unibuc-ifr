package com.cst.unibucifr2025.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class UserModel(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: String,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String
) {
    companion object {
        const val ID = "id"
    }
}

