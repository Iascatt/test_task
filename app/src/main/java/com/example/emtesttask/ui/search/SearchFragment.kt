package com.example.emtesttask.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emtesttask.R
import com.example.emtesttask.databinding.FragmentSearchBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SearchFragment : Fragment() {
    private val viewModel by viewModels<SearchViewModel>()

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchViewModel: SearchViewModel = getViewModel()
        val vacanciesAdapter = VacanciesAdapter()
        val offersAdapter = OffersAdapter()

        view.findViewById<RecyclerView>(R.id.recycler_vacancies).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = vacanciesAdapter
        }
        view.findViewById<RecyclerView>(R.id.recycler_offers).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = offersAdapter
        }
        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.info.collect {
                if (it != null) {
                    vacanciesAdapter.data = it.vacancies
                    offersAdapter.data = it.offers
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}