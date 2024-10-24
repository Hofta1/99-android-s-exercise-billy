package com.assignment.mobileexercise_99

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.mobileexercise_99.data.model.listing.Listing
import com.assignment.mobileexercise_99.presentation.MyViewModel
import com.assignment.mobileexercise_99.adapter.ListingAdapter
import com.assignment.mobileexercise_99.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var listingAdapter: ListingAdapter
    private lateinit var binding:  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        recyclerView = binding.listingRecyclerView
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


