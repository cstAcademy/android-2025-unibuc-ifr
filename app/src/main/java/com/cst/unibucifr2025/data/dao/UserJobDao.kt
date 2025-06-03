package com.cst.unibucifr2025.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cst.unibucifr2025.models.many_to_many.JobWithUsersModel
import com.cst.unibucifr2025.models.many_to_many.UserJobModel

@Dao
interface UserJobDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: UserJobModel)

    @Query("SELECT * FROM UserJobModel WHERE jobId = :id")
    fun getJobWithUsers(id: String): JobWithUsersModel?
}