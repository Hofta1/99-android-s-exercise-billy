package com.example.mobileexercise_99.di

import android.app.Application
import com.example.mobileexercise_99.MyApp
import com.example.mobileexercise_99.data.remote.MyAPI
import com.example.mobileexercise_99.data.repository.MyRepositoryImpl
import com.example.mobileexercise_99.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMyAPI(): MyAPI{
        return Retrofit.Builder()
            .baseUrl("Url")
            .build()
            .create(MyAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideMyRepository(api: MyAPI, app: Application): MyRepository{
        return MyRepositoryImpl(api,app)
    }
}