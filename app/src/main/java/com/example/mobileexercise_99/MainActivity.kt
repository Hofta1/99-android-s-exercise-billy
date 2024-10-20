package com.example.mobileexercise_99

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileexercise_99.data.model.listing.Listing
import com.example.mobileexercise_99.presentation.MyViewModel
import com.example.mobileexercise_99.recyclerview.ListingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var listingAdapter: ListingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.listingRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getData()
        // Use the injected dependency
        viewModel.listings.observe(this) { listings ->
            if (!listings.isNullOrEmpty()) {
                listingAdapter = ListingAdapter(listings){ listing ->
                    onListingClick(listing)
                }
                recyclerView.adapter = listingAdapter
                }
            }
        }

    private fun onListingClick(listing: Listing) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra("id", listing.id)
        }
        startActivity(intent)
    }
}


