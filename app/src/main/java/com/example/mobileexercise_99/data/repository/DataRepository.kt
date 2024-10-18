package com.example.mobileexercise_99.data.repository

import com.example.mobileexercise_99.data.model.details.Details
import com.example.mobileexercise_99.data.model.listing.Listing
import com.example.mobileexercise_99.data.remote.MyAPI
import com.example.mobileexercise_99.di.RetrofitInstance
import javax.inject.Inject

class DataRepository @Inject constructor(private val myAPI: MyAPI){
    suspend fun fetchListing(): List<Listing>{
        return myAPI.getListing()
    }

    suspend fun fetchDetails(): List<Details>{
        return myAPI.getDetails()
    }
}