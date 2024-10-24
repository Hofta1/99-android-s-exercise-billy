package com.assignment.mobileexercise_99.di

import com.assignment.mobileexercise_99.data.remote.MyAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val apiService: MyAPI = retrofit.create(MyAPI::class.java)
}
