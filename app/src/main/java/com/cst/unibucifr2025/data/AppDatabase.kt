package com.cst.unibucifr2025.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cst.unibucifr2025.data.dao.CityDAO
import com.cst.unibucifr2025.data.dao.DirectionDAO
import com.cst.unibucifr2025.data.dao.UserDao
import com.cst.unibucifr2025.data.models.CityEntityModel
import com.cst.unibucifr2025.data.models.DirectionEntityModel
import com.cst.unibucifr2025.models.UserModel

@Database(
    entities = [
        CityEntityModel::class,
        DirectionEntityModel::class,
        UserModel::class
    ],
    version = 3
)
@TypeConverters(
    AppDatabaseConverters::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract val cityDAO: CityDAO
    abstract val directionDao: DirectionDAO
    abstract val userDao: UserDao
}