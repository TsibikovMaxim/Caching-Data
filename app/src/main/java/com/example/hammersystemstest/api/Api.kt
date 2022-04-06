package com.example.hammersystemstest.api

import com.example.hammersystemstest.data.model.ApiModel
import retrofit2.http.GET

interface Api {
    companion object {
        const val BASE_URL = "https://reqres.in/api/"
    }

    @GET("users")
    suspend fun getData(): ApiModel
}