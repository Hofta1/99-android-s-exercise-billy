package com.assignment.mobileexercise_99.data.model.details

import com.google.gson.annotations.SerializedName

data class Details(
    val address: AddressDt,
    val description: String,
    @SerializedName("attributes") val attributesDt: AttributesDt,
    val id: Int,
    val photo: String,
    @SerializedName("project_name") val projectName: String,
    @SerializedName("property_details") val propertyDetails: MutableList<PropertyDetails> = mutableListOf()
)
