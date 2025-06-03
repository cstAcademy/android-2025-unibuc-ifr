package com.cst.unibucifr2025.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cst.unibucifr2025.data.dao.CityDAO
import com.cst.unibucifr2025.data.dao.DirectionDAO
import com.cst.unibucifr2025.data.dao.UserAddressDao
import com.cst.unibucifr2025.data.dao.UserDao
import com.cst.unibucifr2025.data.dao.UserIdentityCardDao
import com.cst.unibucifr2025.data.dao.UserJobDao
import com.cst.unibucifr2025.data.models.CityEntityModel
import com.cst.unibucifr2025.data.models.DirectionEntityModel
import com.cst.unibucifr2025.models.one_to_many.UserAddressModel
import com.cst.unibucifr2025.models.many_to_many.UserJobModel
import com.cst.unibucifr2025.models.UserModel
import com.cst.unibucifr2025.models.many_to_many.UserJobCrossRef
import com.cst.unibucifr2025.models.one_to_one.UserIdentityCardModel

@Database(
    entities = [
        CityEntityModel::class,
        DirectionEntityModel::class,
        UserModel::class,
        UserAddressModel::class,
        UserJobModel::class,
        UserIdentityCardModel::class,
        UserJobCrossRef::class
    ],
    version = 6
)
@TypeConverters(
    AppDatabaseConverters::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract val cityDAO: CityDAO
    abstract val directionDao: DirectionDAO
    abstract val userDao: UserDao
    abstract val identityCardDao: UserIdentityCardDao
    abstract val userAddressDao: UserAddressDao
    abstract val userJobDao: UserJobDao
}