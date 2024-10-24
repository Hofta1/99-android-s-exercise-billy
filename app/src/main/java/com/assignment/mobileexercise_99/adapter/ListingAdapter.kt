package com.assignment.mobileexercise_99.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.assignment.mobileexercise_99.R
import com.assignment.mobileexercise_99.data.model.listing.Listing
import com.assignment.mobileexercise_99.databinding.ItemListingBinding
import java.util.Locale

class ListingAdapter (
    private val listingDetail: List<Listing>,
    private val onItemClick: (Listing) -> Unit) : RecyclerView.Adapter<ListingAdapter.DetailViewHolder>() {

    class DetailViewHolder(private val binding: ItemListingBinding) : RecyclerView.ViewHolder(binding.root) {
        val photo: ImageView = binding.photoIV
        val projectNameTV: TextView = binding.projectNameTV
        val addressTV: TextView = binding.AddressTV
        val descriptionTV: TextView = binding.descriptionTV
        val roomSizeTV: TextView = binding.roomSizeTV
        val priceTV: TextView = binding.priceTV
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding = ItemListingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val listing = listingDetail[position]
        Glide.with(holder.itemView.context)
            .load(listing.photo)
            .into(holder.photo)
        holder.projectNameTV.text = listing.projectName
        holder.addressTV.text = String.format("%s · %s",listing.address.streetName,listing.address.district)
        holder.descriptionTV.text = String.format(Locale.US,"Exec %s · %d · %d yrs", listing.category, listing.completedAt, listing.tenure)
        holder.roomSizeTV.text = String.format(Locale.US,"%d Beds · %d Baths · %d sqft", listing.attributes.bedrooms, listing.attributes.bathrooms, listing.attributes.areaSize)
        holder.priceTV.text = String.format(Locale.US,"$%d/mo", listing.attributes.price)

        holder.itemView.setOnClickListener {
            onItemClick(listing)
        }
    }

    override fun getItemCount(): Int {
        return listingDetail.size
    }
}