package com.cst.unibucifr2025.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.cst.unibucifr2025.data.models.CityEntityModel

@Dao
interface CityDAO {
    @Insert
    suspend fun insert(city: CityEntityModel)
}