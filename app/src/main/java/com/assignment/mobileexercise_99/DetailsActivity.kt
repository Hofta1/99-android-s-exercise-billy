package com.assignment.mobileexercise_99

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.assignment.mobileexercise_99.databinding.ActivityDetailsBinding
import com.assignment.mobileexercise_99.databinding.DetailListingBinding
import com.bumptech.glide.Glide
import com.assignment.mobileexercise_99.presentation.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val container : LinearLayout = binding.detailContainer
        //initialize component
        val backButton: Button = binding.backButton
        val photoIV: ImageView = binding.projectImageView
        val priceTV: TextView = binding.priceTV
        val projectNameTV: TextView = binding.projectNameTV
        val titleTV: TextView = binding.titleTV
         val subtitleTV: TextView = binding.subtitleTV
         val mapButton: Button = binding.mapButton
         val bedTV: TextView = binding.bedTextView
         val bathTV: TextView = binding.bathTextView
         val descriptionTV: TextView = binding.descriptionTextView

        val id = intent.getIntExtra("id", 1)
        viewModel.getData()
        viewModel.details.observe(this) { details ->
            if (!details.isNullOrEmpty()) {
                //inputting value
                Glide.with(this)
                    .load(details[id].photo)
                    .into(photoIV)
                priceTV.text = String.format(Locale.US,"$%d",details[id].attributesDt.price)
                projectNameTV.text = details[id].projectName
                titleTV.text = details[id].address.title
                subtitleTV.text = details[id].address.subtitle
                bedTV.text = details[id].attributesDt.bedrooms.toString()
                bathTV.text = details[id].attributesDt.bathrooms.toString()
                for (item in details[id].propertyDetails){
                    val listItemBinding = DetailListingBinding.inflate(
                        LayoutInflater.from(this),container,false
                    )

                    listItemBinding.detailLabel.text = item.label
                    listItemBinding.detailValue.text = item.text
                    container.addView(listItemBinding.root)
                }
                descriptionTV.text = details[id].description

                //back button
                backButton.setOnClickListener{
                    finish()
                }

                //go to map
                mapButton.setOnClickListener{
                    val latitude = details[id].address.mapCoordinates.lat
                    val longitude = details[id].address.mapCoordinates.lng
                    val intent = Intent(this,MapActivity::class.java).apply {
                        putExtra("latitude", latitude)
                        putExtra("longitude", longitude)
                    }
                    startActivity(intent)

                }

            }

        }
    }
}