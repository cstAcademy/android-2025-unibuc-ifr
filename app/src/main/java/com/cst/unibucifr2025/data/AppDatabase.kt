package com.cst.unibucifr2025.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cst.unibucifr2025.data.dao.CityDAO
import com.cst.unibucifr2025.data.models.CityEntityModel

@Database(
    entities = [CityEntityModel::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase(){
    abstract val cityDAO: CityDAO
}