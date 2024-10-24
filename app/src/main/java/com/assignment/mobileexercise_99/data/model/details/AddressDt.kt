package com.assignment.mobileexercise_99.data.model.details

import com.google.gson.annotations.SerializedName

data class AddressDt(
    @SerializedName("map_coordinates")val mapCoordinates: MapCoordinates,
    val subtitle: String,
    val title: String
)
