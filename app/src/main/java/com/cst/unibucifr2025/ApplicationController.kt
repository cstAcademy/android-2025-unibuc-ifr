package com.cst.unibucifr2025

import android.app.Application
import androidx.room.Room
import com.cst.unibucifr2025.data.AppDatabase

class ApplicationController : Application() {
    companion object {
        var instance: ApplicationController? = null
            private set
    }

    lateinit var appDatabase: AppDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDatabase()
    }

    private fun initDatabase() {
        appDatabase = Room.databaseBuilder(
            context = this,
            klass = AppDatabase::class.java,
            name = "localDatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}