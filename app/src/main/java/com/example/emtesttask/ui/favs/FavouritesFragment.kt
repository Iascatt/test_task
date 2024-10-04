package com.example.emtesttask.ui.favs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emtesttask.R
import com.example.emtesttask.databinding.FragmentFavsBinding
import com.example.emtesttask.domain.models.Vacancy
import com.example.emtesttask.ui.search.SearchViewModel
import com.example.emtesttask.ui.search.VacanciesAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class FavouritesFragment : Fragment() {

    private var _binding: FragmentFavsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFavsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchViewModel: SearchViewModel = getViewModel()
        val vacanciesAdapter = VacanciesAdapter()
        var favs: List<Vacancy>
        view.findViewById<RecyclerView>(R.id.recycler_favs).apply {
            adapter = vacanciesAdapter
            layoutManager = LinearLayoutManager(context)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.info.collect {data ->
                if (data != null) {
                    favs = data.vacancies.filter { it.isFavorite }
                    view.findViewById<TextView>(R.id.number_of_favs).text =
                        view.context.resources.getQuantityString(R.plurals.number_of_favs_string,
                            favs.size, favs.size)
                    vacanciesAdapter.data = favs
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}