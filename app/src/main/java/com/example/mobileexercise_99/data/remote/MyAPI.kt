package com.example.mobileexercise_99.data.remote

import com.example.mobileexercise_99.data.model.details.Details
import com.example.mobileexercise_99.data.model.listing.Listing
import retrofit2.http.GET

interface MyAPI {
    @GET("listings.json")
    suspend fun getListing(): List<Listing>

    @GET("details.json")
    suspend fun getDetails(): List<Details>
}