package com.assignment.mobileexercise_99

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.assignment.mobileexercise_99.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@AndroidEntryPoint
class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var myMap : GoogleMap
    private var lat by Delegates.notNull<Double>()
    private var lng by Delegates.notNull<Double>()
    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var latitude = intent.getDoubleExtra("latitude",1.3884286902614)
        var longitude = intent.getDoubleExtra("longitude",103.87432292478)
        val backButton = binding.backButtonMap
        val gMapsButton = binding.gMapButton
        lat = latitude
        lng = longitude

        initializeMap()

        backButton.setOnClickListener{
            finish()
        }
        gMapsButton.setOnClickListener{
            val uri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                val toast = Toast.makeText(this,"Google Maps isn't installed",Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    private fun initializeMap(){
        val mapFragment = SupportMapFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(binding.map.id, mapFragment).commit()
        mapFragment.getMapAsync(this)
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    myMap.isMyLocationEnabled = true
                    initializeMap()
                }
            }
            else{
                Toast.makeText(this,"Location Permission Is Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onMapReady(p0: GoogleMap) {
        myMap = p0
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),1
            )
            return
        }
        myMap.isMyLocationEnabled = true

        val location = LatLng(lat,lng)
        myMap.addMarker(MarkerOptions().position(location).title("Marker at location"))
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
    }

}