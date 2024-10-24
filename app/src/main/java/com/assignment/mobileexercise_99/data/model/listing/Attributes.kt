package com.assignment.mobileexercise_99.data.model.listing

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("area_size") val areaSize : Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int
)
