package com.example.mobileexercise_99.data.model.listing

import com.google.gson.annotations.SerializedName

data class Listing(
    val address: Address,
    val attributes: Attributes,
    val category: String,
    @SerializedName("completed_at") val completedAt: Int,
    val id: Int,
    val photo: String,
    @SerializedName("project_name")val projectName: String,
    val tenure: Int
)
