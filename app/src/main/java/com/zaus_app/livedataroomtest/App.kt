package com.zaus_app.livedataroomtest

import android.app.Application
import androidx.room.Room
import com.zaus_app.livedataroomtest.dao.StringEntityDAO
import com.zaus_app.livedataroomtest.db.AppDatabase

class App : Application() {
    lateinit var stringEntityDAO: StringEntityDAO

    override fun onCreate() {
        super.onCreate()
        instance = this

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "string_DB")
            .build()
        stringEntityDAO = db.stringEntityDao()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}