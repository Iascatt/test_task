package com.example.emtesttask.ui.search

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.emtesttask.R
import com.example.emtesttask.domain.models.Vacancy
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

class VacancyViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val like: ImageView by lazy { view.findViewById(R.id.like) }
    private val title: TextView by lazy { view.findViewById(R.id.title) }
    private val lookingNumber: TextView by lazy { view.findViewById(R.id.lookingNumber) }
    private val town: TextView by lazy { view.findViewById(R.id.town) }
    private val company: TextView by lazy { view.findViewById(R.id.company) }
    private val exp: TextView by lazy { view.findViewById(R.id.exp) }
    private val publicationDate: TextView by lazy { view.findViewById(R.id.publicationDate) }
    private val salary: TextView by lazy { view.findViewById(R.id.publicationDate) }

    private val view = view

    fun bind(element: Vacancy) {
        title.text = element.title
        lookingNumber.text =  view.context.resources.
        getQuantityString(R.plurals.looking_string, element.lookingNumber, element.lookingNumber)
        town.text = element.address.town
        company.text = element.company
        if (element.salary.short != null) {
            salary.text = element.salary.short
            salary.isVisible = true
        }

        exp.text = element.experience.previewText

        publicationDate.text = view.context.getString(
            R.string.published_string,
            DateTimeFormatter.ofPattern("d MMMM")
            .withLocale(Locale("ru"))
            .format(element.publishedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
        )
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