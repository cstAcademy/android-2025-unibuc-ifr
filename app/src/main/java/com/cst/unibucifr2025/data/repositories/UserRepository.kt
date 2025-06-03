package com.cst.unibucifr2025.data.repositories

import com.cst.unibucifr2025.ApplicationController
import com.cst.unibucifr2025.models.UserModel

object UserRepository {
    suspend fun insert(entities: List<UserModel>) {
        ApplicationController.instance?.appDatabase?.userDao?.insert(entities)
    }

    suspend fun getAllUsers() =
        ApplicationController.instance?.appDatabase?.userDao?.getAll() ?: listOf()


    suspend fun getUserWithIDC(userId: String) =
        ApplicationController.instance?.appDatabase?.userDao?.getUserWithIdentityCard(id = userId)

}