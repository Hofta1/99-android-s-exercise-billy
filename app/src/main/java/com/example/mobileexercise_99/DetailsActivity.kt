package com.example.mobileexercise_99

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mobileexercise_99.presentation.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        val container : LinearLayout = findViewById(R.id.detailContainer)
        //initialize component
        val backButton: Button = findViewById(R.id.backButton)
        val photoIV: ImageView = findViewById(R.id.projectImageView)
        val priceTV: TextView = findViewById(R.id.priceTV)
        val projectNameTV: TextView = findViewById(R.id.projectNameTV)
        val titleTV: TextView = findViewById(R.id.titleTV)
         val subtitleTV: TextView = findViewById(R.id.subtitleTV)
         val mapButton: Button = findViewById(R.id.mapButton)
         val bedTV: TextView = findViewById(R.id.bedTextView)
         val bathTV: TextView = findViewById(R.id.bathTextView)
//         val priceSqftLabel: TextView = findViewById(R.id.pricesqftTitleTextView)
//         val priceSqftTV: TextView = findViewById(R.id.pricesqftTextView)
//         val floorLevelLabel: TextView = findViewById(R.id.floorLevelTitleTextView)
//         val floorLevelTV: TextView = findViewById(R.id.floorLevelTextView)
//         val furnishingLabel: TextView = findViewById(R.id.furnishingTitleTextView)
//         val furnishingTV: TextView = findViewById(R.id.furnishingTextView)
//         val facingLabel: TextView = findViewById(R.id.facingTitleTextView)
//         val facingTV: TextView = findViewById(R.id.facingTextView)
//         val overlookingViewLabel: TextView = findViewById(R.id.overlookingViewTitleTextView)
//         val overlookingViewTV: TextView = findViewById(R.id.overlookingViewTextView)
//         val builtYearLabel: TextView = findViewById(R.id.builtYearTitleTextView)
//         val builtYearTV: TextView = findViewById(R.id.builtYearTextView)
//         val tenureLabel: TextView = findViewById(R.id.tenureTitleTextView)
//         val tenureTV: TextView = findViewById(R.id.tenureTextView)
//         val propertyTypeLabel: TextView = findViewById(R.id.propertyTypeTitleTextView)
//         val propertyTypeTV: TextView = findViewById(R.id.propertyTypeTextView)
//         val lastUpdatedLabel: TextView = findViewById(R.id.lastUpdatedTitleTextView)
//         val lastUpdatedTV: TextView = findViewById(R.id.lastUpdatedTextView)
         val descriptionTV: TextView = findViewById(R.id.descriptionTextView)

        val id = intent.getIntExtra("id", 0)
        viewModel.getData()
        viewModel.details.observe(this) { details ->
            if (!details.isNullOrEmpty()) {
                //inputting value
                Glide.with(this)
                    .load(details[id].photo)
                    .into(photoIV)
                priceTV.text = String.format(Locale.US,"$%d",details[id].attributes.price)
                projectNameTV.text = details[id].projectName
                titleTV.text = details[id].address.title
                subtitleTV.text = details[id].address.subtitle
//                mapButton = details[id].
                bedTV.text = details[id].attributes.bedrooms.toString()
                bathTV.text = details[id].attributes.bathrooms.toString()
                for (item in details[id].propertyDetails){
                    val listItem = LayoutInflater.from(this).inflate(
                        R.layout.detail_listing,container,false
                    )
                   val labelTV: TextView =  listItem.findViewById(R.id.detailLabel)
                    val valueTV: TextView = listItem.findViewById(R.id.detailValue)
                    labelTV.text = item.label
                    valueTV.text = item.text
                    container.addView(listItem)
                }
                descriptionTV.text = details[id].description
                backButton.setOnClickListener{
                    finish()
//                    val intent = Intent(this,MainActivity::class.java)
//                    startActivity(intent)
                }
            }

        }
    }
}