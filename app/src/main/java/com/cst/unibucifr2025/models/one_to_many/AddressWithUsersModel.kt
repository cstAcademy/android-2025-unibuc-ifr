package com.cst.unibucifr2025.models.one_to_many

import androidx.room.Embedded
import androidx.room.Relation
import com.cst.unibucifr2025.models.UserModel

data class AddressWithUsersModel(
    @Embedded
    val addressModel: UserAddressModel,
    @Relation(
        parentColumn = UserAddressModel.ID,
        entityColumn = UserModel.ADDRESS_ID
    )
    val users: List<UserModel>
)
