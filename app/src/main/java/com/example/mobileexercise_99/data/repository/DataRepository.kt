package com.example.mobileexercise_99.data.repository

import com.example.mobileexercise_99.data.model.details.Details
import com.example.mobileexercise_99.data.model.listing.Listing
import com.example.mobileexercise_99.data.remote.MyAPI
import javax.inject.Inject

class DataRepository @Inject constructor(private val myAPI: MyAPI){
    suspend fun fetchListing(): List<Listing>{
        return myAPI.getListing()
    }

    suspend fun fetchDetails(): List<Details>{
        println("hello")
        val details = myAPI.getDetails()
        println("Fetched Details: $details")
        return details
    }
}