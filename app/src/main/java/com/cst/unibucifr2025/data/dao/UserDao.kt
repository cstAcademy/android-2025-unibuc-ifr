package com.cst.unibucifr2025.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cst.unibucifr2025.models.UserModel
import com.cst.unibucifr2025.models.one_to_one.UserWithIDModel

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(users: List<UserModel>)

    @Query("SELECT * FROM UserModel")
    suspend fun getAll(): List<UserModel>

    @Query("SELECT * FROM usermodel WHERE id = :id")
    suspend fun getUserWithIdentityCard(id: String): UserWithIDModel
}