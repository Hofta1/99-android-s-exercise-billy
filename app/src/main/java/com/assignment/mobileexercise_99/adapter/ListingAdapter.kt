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
import java.util.Locale

class ListingAdapter (
    private val listingDetail: List<Listing>,
    private val onItemClick: (Listing) -> Unit) : RecyclerView.Adapter<ListingAdapter.DetailViewHolder>() {

    class DetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.photoIV)
        val projectNameTV: TextView = view.findViewById(R.id.projectNameTV)
        val addressTV: TextView = view.findViewById(R.id.AddressTV)
        val descriptionTV: TextView = view.findViewById(R.id.descriptionTV)
        val roomSizeTV: TextView = view.findViewById(R.id.roomSizeTV)
        val priceTV: TextView = view.findViewById(R.id.priceTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_listing, parent, false)
        return DetailViewHolder(view)
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