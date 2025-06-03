package com.cst.unibucifr2025.data.repositories

import com.cst.unibucifr2025.ApplicationController
import com.cst.unibucifr2025.models.many_to_many.UserJobModel

object UserJobRepository {

    suspend fun insert(entity: UserJobModel) {
        ApplicationController.instance?.appDatabase?.userJobDao?.insert(entity)
    }

    suspend fun getJobWithUsers(jobId: String) =
        ApplicationController.instance?.appDatabase?.userJobDao?.getJobWithUsers(id = jobId)

}