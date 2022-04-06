package com.example.hammersystemstest.data

import androidx.room.withTransaction
import com.example.hammersystemstest.api.Api
import com.example.hammersystemstest.util.networkBoundResource

import kotlinx.coroutines.delay
import javax.inject.Inject

class PizzaRepository @Inject constructor(
    private val api: Api,
    private val db: PizzaDatabase
) {
    private val pizzaDao = db.pizzaDao()

    fun getData() = networkBoundResource(
        query = {
            pizzaDao.getAllData()
        },
        fetch = {
            delay(2000)
            api.getData()
        },
        saveFetchResult = { data ->
            db.withTransaction {
                pizzaDao.deleteAllData()
                pizzaDao.insertData(
                    data)
            }
        }
    )
}