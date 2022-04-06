package com.example.hammersystemstest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hammersystemstest.data.model.ApiModel
import kotlinx.coroutines.flow.Flow

@Dao
interface PizzaDao {

    @Query("SELECT * FROM data")
    fun getAllData(): Flow<ApiModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(restaurants: ApiModel)

    @Query("DELETE FROM data")
    suspend fun deleteAllData()
}