package com.cst.unibucifr2025.models.one_to_one

import androidx.room.Embedded
import androidx.room.Relation
import com.cst.unibucifr2025.models.UserModel

data class UserWithIDModel (
    @Embedded
    val user: UserModel,
    @Relation(
        parentColumn = UserModel.ID,
        entityColumn = UserIdentityCardModel.OWNER_ID
    )
    val id: UserIdentityCardModel
)