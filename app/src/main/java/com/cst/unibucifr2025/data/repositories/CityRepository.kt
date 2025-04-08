package com.cst.unibucifr2025.data.repositories

import com.cst.unibucifr2025.ApplicationController
import com.cst.unibucifr2025.data.models.CityEntityModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CityRepository {
    fun insert(entityModel: CityEntityModel){
        CoroutineScope(Dispatchers.IO).launch {
            ApplicationController.instance?.appDatabase?.cityDAO?.insert(entityModel)
        }
    }
}