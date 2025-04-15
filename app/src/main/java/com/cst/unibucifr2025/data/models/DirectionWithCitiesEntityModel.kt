package com.cst.unibucifr2025.data.models

import androidx.room.Embedded
import androidx.room.Relation


data class DirectionWithCitiesEntityModel (
    @Embedded
    val direction: DirectionEntityModel,
    @Relation (
        parentColumn = DirectionEntityModel.ID,
        entityColumn = CityEntityModel.OWNER_ID
    )
    val citiesList: List<CityEntityModel>
)