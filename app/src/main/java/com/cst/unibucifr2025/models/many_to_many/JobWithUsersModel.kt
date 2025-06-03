package com.cst.unibucifr2025.models.many_to_many

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.cst.unibucifr2025.models.UserModel

data class JobWithUsersModel(
    @Embedded
    val job: UserJobModel,
    @Relation(
        parentColumn = UserJobModel.ID,
        entityColumn = UserModel.ID,
        associateBy = Junction(UserJobCrossRef::class)
    )
    val users: List<UserModel>
)