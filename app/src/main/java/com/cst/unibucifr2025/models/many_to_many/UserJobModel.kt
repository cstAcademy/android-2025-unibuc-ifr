package com.cst.unibucifr2025.models.many_to_many

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserJobModel(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val jobId: String,
    val title: String
) {
    companion object {
        const val ID = "jobId"
    }
}