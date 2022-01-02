package com.zaus_app.livedataroomtest.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zaus_app.livedataroomtest.entity.StringEntity

@Dao
interface StringEntityDAO {
    @Query("SELECT * FROM string_table ORDER BY id DESC LIMIT 1")
    fun getLastData(): LiveData<StringEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun putData(stringEntity: StringEntity)
}