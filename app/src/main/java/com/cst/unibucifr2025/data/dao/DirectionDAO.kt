package com.cst.unibucifr2025.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cst.unibucifr2025.data.models.DirectionEntityModel
import com.cst.unibucifr2025.data.models.DirectionWithCitiesEntityModel

@Dao
interface DirectionDAO {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(direction: DirectionEntityModel)
    @Query ("""
        SELECT * FROM DirectionEntityModel;
    """)
    suspend fun getDirectionsWithCities(): List<DirectionWithCitiesEntityModel>
}