package com.example.mobileexercise_99.data.model.listing

import com.google.gson.annotations.SerializedName

data class Address(
    val district: String,
    @SerializedName("street_name") val streetName: String
)
