package com.example.mobileexercise_99.data.model.listing

data class Listing(
    val address: Address,
    val attributes: Attributes,
    val category: String,
    val completedAt: Int,
    val id: Int,
    val photo: String,
    val projectName: String,
    val tenure: Int
)
