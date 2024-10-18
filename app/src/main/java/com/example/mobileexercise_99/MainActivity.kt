package com.example.mobileexercise_99

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileexercise_99.presentation.MyViewModel
import com.example.mobileexercise_99.recyclerview.ListingAdapter
import com.example.mobileexercise_99.ui.theme.MobileExercise_99Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var listingAdapter: ListingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Hello")
        recyclerView = findViewById(R.id.listingRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getData()
        // Use the injected dependency
        viewModel.listings.observe(this) { listings ->
            if (!listings.isNullOrEmpty()) {
                listingAdapter = ListingAdapter(listings)
                recyclerView.adapter = listingAdapter
            }
        }
        }
    }