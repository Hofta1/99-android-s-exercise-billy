package com.assignment.mobileexercise_99.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.mobileexercise_99.data.model.details.Details
import com.assignment.mobileexercise_99.data.model.listing.Listing
import com.assignment.mobileexercise_99.data.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {
    private val _listings = MutableLiveData<List<Listing>>()
    val listings: LiveData<List<Listing>> get() = _listings

    private val _details = MutableLiveData<List<Details>>()
    val details: LiveData<List<Details>> get() = _details

    fun getData() {
        viewModelScope.launch {
            try {
                _listings.value = repository.fetchListing()
                _details.value = repository.fetchDetails()
            } catch (e: Exception) {
                _listings.value = emptyList()
                _details.value = emptyList()
            }
        }
    }
}