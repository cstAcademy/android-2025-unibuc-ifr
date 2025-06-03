package com.cst.unibucifr2025.models.many_to_many

import androidx.room.Entity
import com.cst.unibucifr2025.models.UserModel

@Entity(
    primaryKeys = [
        UserModel.ID,
        UserJobModel.ID
    ]
)
data class UserJobCrossRef(
    val id: String,
    val jobId: String
)
