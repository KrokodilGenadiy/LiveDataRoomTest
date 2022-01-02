package com.zaus_app.livedataroomtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zaus_app.livedataroomtest.dao.StringEntityDAO
import com.zaus_app.livedataroomtest.entity.StringEntity

@Database(entities = [StringEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun stringEntityDao(): StringEntityDAO
}