package com.example.mobileexercise_99.di

import android.app.Application
import com.example.mobileexercise_99.MyApp
import com.example.mobileexercise_99.data.model.listing.Listing
import com.example.mobileexercise_99.data.remote.MyAPI
import com.example.mobileexercise_99.domain.repository.MyRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/"


    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun profideApiService(retrofit: Retrofit): MyAPI{
        return retrofit.create(MyAPI::class.java)
    }
}