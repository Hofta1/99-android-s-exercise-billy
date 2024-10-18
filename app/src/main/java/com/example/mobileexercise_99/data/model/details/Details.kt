package com.example.mobileexercise_99.data.model.details

data class Details(
    val address: AddressDt,
    val description: String,
    val id: Int,
    val photo: Int,
    val projectName: MutableList<PropertyDetails> = mutableListOf()
)
