package com.example.emtesttask.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emtesttask.R
import com.example.emtesttask.domain.models.Offer
import com.example.emtesttask.domain.models.Vacancy

class OffersAdapter : RecyclerView.Adapter<OfferViewHolder>() {
    var data: List<Offer> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_offer, parent, false)
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offer = data[position]
        holder.bind(offer)
    }


    override fun getItemCount(): Int {
        return data.size
    }

}