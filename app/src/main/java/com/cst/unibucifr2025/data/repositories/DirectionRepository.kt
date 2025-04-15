package com.cst.unibucifr2025.data.repositories

import com.cst.unibucifr2025.ApplicationController
import com.cst.unibucifr2025.data.models.DirectionEntityModel
import com.cst.unibucifr2025.data.models.DirectionWithCitiesEntityModel
import com.cst.unibucifr2025.utils.extensions.logErrorMessage

object DirectionRepository {
    suspend fun insert(entityModel: DirectionEntityModel) {
        ApplicationController.instance?.appDatabase?.directionDao?.insert(entityModel)
    }

    suspend fun getAllDirectionsWithCities():List<DirectionWithCitiesEntityModel> {
        return ApplicationController.instance?.appDatabase?.directionDao?.getDirectionsWithCities() ?: listOf()
    }
}