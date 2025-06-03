package com.cst.unibucifr2025.data.repositories

import com.cst.unibucifr2025.ApplicationController
import com.cst.unibucifr2025.models.one_to_many.UserAddressModel

object UserAddressRepository {
    suspend fun insert(entities: List<UserAddressModel>) {
        ApplicationController.instance?.appDatabase?.userAddressDao?.insert(entities)
    }

    suspend fun getAddressWithUsers(id: String) =
        ApplicationController.instance?.appDatabase?.userAddressDao?.getAddressWithUsers(id)
}