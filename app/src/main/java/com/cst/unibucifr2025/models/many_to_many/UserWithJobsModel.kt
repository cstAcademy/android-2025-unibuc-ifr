package com.cst.unibucifr2025.models.many_to_many

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.cst.unibucifr2025.models.UserModel

data class UserWithJobsModel(
    @Embedded
    val user: UserModel,
    @Relation(
        parentColumn = UserModel.ID,
        entityColumn = UserJobModel.ID,
        associateBy = Junction(UserJobCrossRef::class)
    )
    val jobs: List<UserJobModel>
)