package com.example.mobileexercise_99.presentation

import androidx.lifecycle.ViewModel
import com.example.mobileexercise_99.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: MyRepository): ViewModel() {

}