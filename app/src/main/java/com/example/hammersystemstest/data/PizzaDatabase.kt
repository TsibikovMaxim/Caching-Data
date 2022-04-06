package com.example.hammersystemstest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.hammersystemstest.data.model.ApiModel

@Database(entities = [ApiModel::class], version = 1)
@TypeConverters(Converter::class)
abstract class PizzaDatabase : RoomDatabase() {

    abstract fun pizzaDao(): PizzaDao
}