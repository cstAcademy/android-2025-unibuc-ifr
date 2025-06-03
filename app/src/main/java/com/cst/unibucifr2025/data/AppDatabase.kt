package com.cst.unibucifr2025.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cst.unibucifr2025.data.dao.CityDAO
import com.cst.unibucifr2025.data.dao.DirectionDAO
import com.cst.unibucifr2025.data.dao.UserDao
import com.cst.unibucifr2025.data.dao.UserIdentityCardDao
import com.cst.unibucifr2025.data.models.CityEntityModel
import com.cst.unibucifr2025.data.models.DirectionEntityModel
import com.cst.unibucifr2025.models.UserAddressModel
import com.cst.unibucifr2025.models.UserJobModel
import com.cst.unibucifr2025.models.UserModel
import com.cst.unibucifr2025.models.one_to_one.UserIdentityCardModel

@Database(
    entities = [
        CityEntityModel::class,
        DirectionEntityModel::class,
        UserModel::class,
        UserAddressModel::class,
        UserJobModel::class,
        UserIdentityCardModel::class
    ],
    version = 4
)
@TypeConverters(
    AppDatabaseConverters::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract val cityDAO: CityDAO
    abstract val directionDao: DirectionDAO
    abstract val userDao: UserDao
    abstract val identityCardDao: UserIdentityCardDao
}