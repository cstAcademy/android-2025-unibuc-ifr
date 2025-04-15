package com.cst.unibucifr2025.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cst.unibucifr2025.data.dao.CityDAO
import com.cst.unibucifr2025.data.dao.DirectionDAO
import com.cst.unibucifr2025.data.models.CityEntityModel
import com.cst.unibucifr2025.data.models.DirectionEntityModel

@Database(
    entities = [CityEntityModel::class, DirectionEntityModel::class],
    version = 2
)
@TypeConverters(
    AppDatabaseConverters::class
)
abstract class AppDatabase: RoomDatabase(){
    abstract val cityDAO: CityDAO
    abstract val directionDao: DirectionDAO
}