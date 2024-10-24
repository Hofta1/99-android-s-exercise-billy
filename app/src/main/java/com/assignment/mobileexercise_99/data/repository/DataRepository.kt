package com.assignment.mobileexercise_99.data.repository

import com.assignment.mobileexercise_99.data.model.details.Details
import com.assignment.mobileexercise_99.data.model.listing.Listing
import com.assignment.mobileexercise_99.data.remote.MyAPI
import javax.inject.Inject

open class DataRepository @Inject constructor(private val myAPI: MyAPI){
    suspend fun fetchListing(): List<Listing>{
        return myAPI.getListing()
    }

    suspend fun fetchDetails(): List<Details>{
        return myAPI.getDetails()
    }
}