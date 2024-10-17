package com.example.mobileexercise_99.data.repository

import android.app.Application
import com.example.mobileexercise_99.R
import com.example.mobileexercise_99.data.remote.MyAPI
import com.example.mobileexercise_99.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyAPI,
    private val appContext: Application
): MyRepository {
    init {
        val appName = appContext.getString(R.string.app_name)
        println("Message from repository, The app name is $appName")
    }
    override suspend fun doNetworkCall() {

    }
}