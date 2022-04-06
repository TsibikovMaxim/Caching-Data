package com.example.hammersystemstest.di

import android.app.Application
import androidx.room.Room
import com.example.hammersystemstest.api.Api
import com.example.hammersystemstest.data.PizzaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api =
        retrofit.create(Api::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : PizzaDatabase =
        Room.databaseBuilder(app, PizzaDatabase::class.java, "database")
            .build()
}