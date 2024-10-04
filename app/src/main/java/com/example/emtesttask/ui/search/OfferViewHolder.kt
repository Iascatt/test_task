package com.example.emtesttask.ui.search

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.emtesttask.R
import com.example.emtesttask.domain.models.Offer
import com.example.emtesttask.domain.models.Vacancy
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

class OfferViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val icon: ImageView by lazy { view.findViewById(R.id.offer_icon) }
    private val title: TextView by lazy { view.findViewById(R.id.title) }
    private val button_text: TextView by lazy { view.findViewById(R.id.button_text) }

    private val view = view

    fun bind(element: Offer) {
        title.text = element.title
        button_text.text = element.button?.text ?: ""

        /*view.setOnClickListener {
            val trasaction = view.findFragment<Fragment>().activity?.supportFragmentManager?.beginTransaction()
            if (trasaction != null) {
                trasaction.replace(R.id.container, ArticleFragment.newInstance(element))
                trasaction.addToBackStack(null)
                trasaction.commit()
            }
        }*/
    }
}