package com.cst.unibucifr2025.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.cst.unibucifr2025.models.one_to_one.UserIdentityCardModel

@Dao
interface UserIdentityCardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(users: List<UserIdentityCardModel>)
}