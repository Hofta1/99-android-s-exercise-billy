package com.example.mobileexercise_99.data.model.details

import com.google.gson.annotations.SerializedName

data class Details(
    val address: AddressDt,
    val description: String,
    val attributes: Attributes,
    val id: Int,
    val photo: String,
    @SerializedName("project_name") val projectName: String,
    @SerializedName("property_details") val propertyDetails: MutableList<PropertyDetails> = mutableListOf()
)
