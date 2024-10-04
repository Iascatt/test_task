package com.example.emtesttask.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.emtesttask.R
import com.example.emtesttask.domain.models.Vacancy

class VacanciesAdapter : RecyclerView.Adapter<VacancyViewHolder>() {
    var data: List<Vacancy> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_vacancy, parent, false)
        return VacancyViewHolder(view)
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        val vacancy = data[position]
        holder.bind(vacancy)
    }


    override fun getItemCount(): Int {
        return data.size
    }
}