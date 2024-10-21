package com.example.mobileexercise_99.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileexercise_99.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object GoogleMapsModule {
    @Provides
    fun provideMapFragment(activity: Activity): SupportMapFragment {
        return (activity as AppCompatActivity)
            .supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
    }

}