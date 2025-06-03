package com.cst.unibucifr2025.data.repositories

import com.cst.unibucifr2025.ApplicationController
import com.cst.unibucifr2025.models.UserModel
import com.cst.unibucifr2025.models.many_to_many.UserJobCrossRef

object UserRepository {
    suspend fun insert(entities: List<UserModel>) {
        ApplicationController.instance?.appDatabase?.userDao?.insert(entities)
    }

    suspend fun getAllUsers() =
        ApplicationController.instance?.appDatabase?.userDao?.getAll() ?: listOf()


    suspend fun getUserWithIDC(userId: String) =
        ApplicationController.instance?.appDatabase?.userDao?.getUserWithIdentityCard(id = userId)

    suspend fun getUserWithJobs(userId: String) =
        ApplicationController.instance?.appDatabase?.userDao?.getUserWithJobs(id = userId)

    suspend fun insertUserWithJob(
        userId: String,
        jobId: String
    ) {
        ApplicationController
            .instance
            ?.appDatabase
            ?.userDao
            ?.insertUserWithJobs(
                UserJobCrossRef(
                    id = userId,
                    jobId = jobId
                )
            )
    }
}