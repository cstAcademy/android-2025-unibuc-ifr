package com.cst.unibucifr2025.data.repositories

import com.cst.unibucifr2025.ApplicationController
import com.cst.unibucifr2025.models.one_to_one.UserIdentityCardModel

object UserIdentityCardRepository {
    suspend fun insert(entities: List<UserIdentityCardModel>) {
        ApplicationController.instance?.appDatabase?.identityCardDao?.insert(entities)
    }
}