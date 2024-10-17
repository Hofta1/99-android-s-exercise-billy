package com.example.mobileexercise_99.data.remote

import retrofit2.http.GET

interface MyAPI {
    @GET("test")
    suspend fun doNetworkCall()
}